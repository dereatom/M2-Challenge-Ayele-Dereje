package com.company.M2ChallengeAyeleDereje.controller;

import com.company.M2ChallengeAyeleDereje.model.Maths;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathsController {

  @RequestMapping(value = "/add", method = RequestMethod.POST)
  @ResponseStatus(value = HttpStatus.CREATED)
  public Maths createMathsAdd(@RequestBody Maths maths) {
    maths.setAnswer(maths.getOperand1() + maths.getOperand2());

    return maths;
  }

  @RequestMapping(value = "/divide", method = RequestMethod.POST)
  @ResponseStatus(value = HttpStatus.CREATED)
  public Maths createMathsDivide(@RequestBody Maths divide) {
    divide.setAnswer(divide.getOperand1() / divide.getOperand2());
    if(divide.getOperand2() == 0) {
      throw new IllegalArgumentException("Denominator cannot be zero");
    }

    return divide;

  }

  @RequestMapping(value = "/multiply", method = RequestMethod.POST)
  @ResponseStatus(value = HttpStatus.CREATED)
  public Maths createMathsMultiply(@RequestBody Maths multiply) {
    multiply.setAnswer(multiply.getOperand1() * multiply.getOperand2());
    return multiply;

  }

  @RequestMapping(value = "/subtract", method = RequestMethod.POST)
  @ResponseStatus(value = HttpStatus.CREATED)
  public Maths createMathsSubtract(@RequestBody Maths subtract) {
    subtract.setAnswer(subtract.getOperand1() - subtract.getOperand2());
    return subtract;

  }

}
