package com.tyma.demo.controller;

import com.tyma.demo.readSequence.ReadFasta;
import com.tyma.demo.readSequence.ReadSequence;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.TimeUnit;

@Controller
public class CompareController {

    private final String UPLOAD_DIR = "src/main/resources/uploads/";
    private String[] string;
    ReadFasta readFasta;

    @GetMapping("/")
    public String homepage(Model model){
        File folder = new File(UPLOAD_DIR);
        File[] listOfFiles = folder.listFiles();
        model.addAttribute("listOfFiles",listOfFiles);
        return "index.html";
    }

    @PostMapping("/upload")
    //upload new fasta file
    public String readFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) throws FileNotFoundException {
        //Upload just a valid fasta file
        if (file.getSize()==0 || !getFileExtension(file).equals("fasta")) {
            attributes.addFlashAttribute("message", "Please select a valid fasta file to upload.");
            return "redirect:/";
        }
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        // save the file on the local file system
        try {
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // return success response
        attributes.addFlashAttribute("message", "You successfully uploaded " + fileName + '!');
        return "redirect:/";
    }


    @PostMapping("/compare")
    public String compare(@RequestParam("firstSeq") String firstSeq,@RequestParam("secondSeq") String secondSeq,
                          @RequestParam(value="w",defaultValue = "0") String w,@RequestParam(value="threshold",defaultValue = "0") String threshold,RedirectAttributes attributes) throws FileNotFoundException{
        //to get the sequences from the fasta file
        ReadSequence readSeq=new ReadSequence();
        //get fasta file location
        String sFirstSeq=UPLOAD_DIR + firstSeq;
        String sSecondSeq=UPLOAD_DIR + secondSeq;
        int size=Integer.parseInt(w);
        int thre=Integer.parseInt(threshold);
        if(size!=0 && thre!=0){
            //Compare two seq with word size and threshold
            readFasta.CompareSequenceThresh(readSeq.SecuenciaA(sFirstSeq),readSeq.SecuenciaA(sSecondSeq),size,thre);
        }
        else{
            //Compare two seq
            readFasta.CompareSequence(readSeq.SecuenciaA(sFirstSeq),readSeq.SecuenciaA(sSecondSeq));
        }
        RunPython();
        attributes.addFlashAttribute("message", "Please press on the image to download.");
        return "redirect:/";
    }

    public void RunPython(){
        try{
            //Delete the last image if it exists
            File file = new File("src/main/resources/static/img/img.png");
            if(file.exists()){
                file.delete();
            }
            String matrix = "matrix.txt";
            Process p = Runtime.getRuntime().exec("python dotplot.py"+" "+matrix);
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            //Delay until python file create the new image
            while(!file.exists())
            {
                TimeUnit.SECONDS.sleep(1);
            }
            System.out.println("Python end");
        }catch(Exception e){

        }
    }

    public String getFileExtension(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }



}
