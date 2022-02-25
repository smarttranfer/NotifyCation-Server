package com.pushnotify.pushnotify.controller;

import Map_config.map_json;
import com.pushnotify.pushnotify.dto.NotificationRequestDto;
import com.pushnotify.pushnotify.dto.SubscriptionRequestDto;
import com.pushnotify.pushnotify.service.NotificationService;
import com.pushnotify.pushnotify.service.ServiceToken;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    public ServiceToken servicetoken;

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/subscribe")
    public void subscribeToTopic(@RequestBody SubscriptionRequestDto subscriptionRequestDto) {
        notificationService.subscribeToTopic(subscriptionRequestDto);
    }

    @PostMapping("/unsubscribe")
    public void unsubscribeFromTopic(SubscriptionRequestDto subscriptionRequestDto) {
        notificationService.unsubscribeFromTopic(subscriptionRequestDto);
    }


    @PostMapping(value = "/Pushnotify", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object sendPns(@RequestBody List<NotificationRequestDto> notificationRequestDto) throws JSONException {
        try {
            for(NotificationRequestDto notificationRequestDtos : notificationRequestDto){
                for(String user : notificationRequestDtos.getUser()){
                    for(String token : servicetoken.getoken_client(user)){
                        JSONObject ob = new JSONObject(map_json.jsons);
                        String firstName = ob.getString(notificationRequestDtos.getType());
                        notificationService.sendPnsToDevice(notificationRequestDtos,token,firstName);
                    }
                }

            }
            JSONObject resultNode = new JSONObject(String.format("{\"Status\":\"200\", \"Content\":\"%s\"}", "send messenger sucessfull"));
            return ResponseEntity.ok(resultNode.toString());
        } catch (Exception e) {
            JSONObject resultNode = new JSONObject(String.format("{\"Status\":\"Fail\", \"Content\":\"%s\"}", "send messenger unsucessfull"));
            return ResponseEntity.badRequest();
        }
    }

    @PostMapping(value = "/UpdateToken", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> GetTokens(@RequestParam String token, @RequestParam String user) throws JSONException {
        try {
            if (servicetoken.Settoken(token, user) == true) {
                JSONObject resultNode = new JSONObject(String.format("{\"Status\":\"200\", \"Content\":\"%s\"}", "Update token succesfull"));
                return ResponseEntity.ok(resultNode.toString());
            } else {
                JSONObject resultNode = new JSONObject(String.format("{\"Status\":\"Fail\", \"Content\":\"%s\"}", "Update token broken"));
                return ResponseEntity.ok(resultNode.toString());
            }


        } catch (Exception e) {
            JSONObject resultNode = new JSONObject(String.format("{\"Status\":\"Fail\", \"Content\":\"%s\"}", "Update token broken"));
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }

    }

    @PostMapping(value = "/DeleteToken", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> Delete(@RequestParam String token, @RequestParam String user) throws JSONException {
        try {
            if (servicetoken.deteleToken(token, user) == true) {
                JSONObject resultNode = new JSONObject(String.format("{\"Status\":\"200\", \"Content\":\"%s\"}", "Update token succesfull"));
                return ResponseEntity.ok(resultNode.toString());
            } else {
                JSONObject resultNode = new JSONObject(String.format("{\"Status\":\"Fail\", \"Content\":\"%s\"}", "Update token broken"));
                return ResponseEntity.ok(resultNode.toString());
            }


        } catch (Exception e) {
            JSONObject resultNode = new JSONObject(String.format("{\"Status\":\"Fail\", \"Content\":\"%s\"}", e));
            return ResponseEntity.ok(resultNode.toString());
        }

    }

    @PostMapping("/topic")
    public String sendPnsToTopic(@RequestBody NotificationRequestDto notificationRequestDto) {
        return notificationService.sendPnsToTopic(notificationRequestDto);
    }
}
