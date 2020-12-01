package com.hussain.hw4.controllers;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class MainController {

    //I do not know why my springboot crashes when the Repo class is called.
   /*@Autowired
   MovieRepo movieRepo;

    /*@RequestMapping("/")
    public ModelAndView doHome(){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("movielist", movieRepo.findAll());
        return mv;
    }*/

    //GET method was applied to get information from api call
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView get(@RequestParam("id") String id) {
        ModelAndView mv = new ModelAndView("redirect:/");
        String mname = getMovieById(id);
        try {


            JSONObject json = new JSONObject(mname);
            mv.addObject("Title", json.getString("Title"));
            mv.addObject("Year", json.getString("Year"));

        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        return mv;
    }

    //post method was applied to save it in the database

  /*  @RequestMapping(value = "/save", method = RequestMethod.POST)
    public  ModelAndView save(@RequestParam("id") String id){
        ModelAndView mv = new ModelAndView("redirect:/");
        Movie movieToSave;
        movieToSave = new Movie();
        movieToSave.setTitle(id);
        movieRepo.save(movieToSave);
        mv.addObject("movielist", movieRepo.findAll());
        return mv;

    }*/


    //API ID was called in for specific object

    private String getMovieById(String id) {
        try {
            String apiKey = "e06f76b7";
            URL urlForGetRequest = new URL("http://www.omdbapi.com/?i=" + id + "&apikey=" + apiKey );


            HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
            connection.setRequestMethod("GET");
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {


                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();
                return response.toString();
            } else {
                return "Unexpected HTTP response";
            }
        } catch (Exception e) {
            return "Exception: " + e.getMessage();
        }
    }




}


class Hero
{
    private String name;
    public String getName()
    {
        return name;
    }
    public Hero()
    {
        name = "DEFAULT";
    }
    public Hero(String n)
    {
        name = n;
    }
}


