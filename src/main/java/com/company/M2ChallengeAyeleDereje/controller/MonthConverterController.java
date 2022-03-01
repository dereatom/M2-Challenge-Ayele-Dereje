package com.company.M2ChallengeAyeleDereje.controller;

import com.company.M2ChallengeAyeleDereje.model.Month;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class MonthConverterController {
/*    Month converter controller...................*/
    private static List<Month> monthList = new ArrayList<>(Arrays.asList(
            new Month("January", 1),
            new Month("February", 2),
            new Month("March",3 ),
            new Month("April", 4),
            new Month("May", 5),
            new Month("June", 6),
            new Month("July", 7),
            new Month("August", 8),
            new Month("September", 9),
            new Month("October", 10),
            new Month("November", 11),
            new Month("December", 12)
    ));

   @GetMapping("/month/{monthNumber}")
   @ResponseStatus(HttpStatus.OK)
    public Month getMonthByMonthNumber(@PathVariable int monthNumber) {
       Month foundMonth = null;
       for (Month month : monthList) {
           if (month.getMonthNumber() == monthNumber) {
               foundMonth = month;
               break;
           }

           }
       return foundMonth;
   }

/*  GET a Random month controller .....................*/
    @GetMapping("/randomMonth")
    @ResponseStatus(HttpStatus.OK)
    public Month getRandomMonth() {
        int max = 12;
        int min = 1;
        Random rd =  new Random();
        int randomNumber = rd.nextInt((max - min) + 1) + min;
        Month month = new Month();
        month.setMonthNumber(randomNumber);

        switch (randomNumber) {
            case 1:
                month.setName("January");
                break;
            case 2:
                month.setName("February");
                break;
            case 3:
                month.setName("March");
                break;
            case 4:
                month.setName("April");
                break;
            case 5:
                month.setName("May");
                break;
            case 6:
                month.setName("June");
                break;
            case 7:
                month.setName("July");
                break;
            case 8:
                month.setName("August");
                break;
            case 9:
                month.setName("September");
                break;
            case 10:
                month.setName("October");
                break;
            case 11:
                month.setName("November");
                break;
            case 12:
                month.setName("December");
                break;
        }
        return month;
    }

}
