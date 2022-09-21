package com.demo.googleYouTubeDataAPIv3ExploreWithJava;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.io.IOException;

import java.net.URI;



@org.springframework.stereotype.Controller
public class Controller {
    @Value("${redirect_uri}")
    private String redirectUri;
    @Value("${client_id}")
    private String clientId;
    @Value("${scope}")
    private String scope;


    @GetMapping("/")
    @ResponseBody
    public String root(){

        return "google YouTube Data API v3 Explore With Java";
    }

    // Redirect to Google's OAuth 2.0 server
    @GetMapping("/authorization")
    public ResponseEntity<Void> getAuthorization(){
        String url = "https://accounts.google.com/o/oauth2/v2/auth?client_id="+clientId+""+
                "&redirect_uri="+redirectUri+"&response_type=code&scope="+scope+"";



        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(url.replace(" ", "%20"))).build();
    };


    //Exchange authorization code for access tokens
    @GetMapping("/after")
    @ResponseBody
    public String getAuthorizationCode(@RequestParam(name = "code") String code) throws IOException {



        return "ok";


    };
}
