/* 

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.bind.form
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_F1Test extends ZTL4ScalaTestCase {
  def testArg = {

    var zul = """
      <include src="/bind/form/F1.zul"/>
"""

    runZTL(zul, () => {

      val registerButton = engine.$f("registerButton")
      val message = engine.$f("message")
      val accountBox = engine.$f("accountBox")
      val passwordBox = engine.$f("passwordBox")
      val passwordBox2 = engine.$f("passwordBox2")
      val birthdayBox = engine.$f("birthdayBox")

      click(registerButton);
      verifyEquals("NOT an adult.", jq(message).text());

      `type`(accountBox, "john");
      `type`(passwordBox, "1");
      `type`(passwordBox2, "2");
      click(registerButton);
      waitResponse();
      verifyEquals("NOT an adult.", jq(message).text());

      `type`(passwordBox2, "1");
      click(registerButton);
      waitResponse();
      verifyEquals("Hi, john: You are NOT an adult.", jq(message).text());

      `type`(birthdayBox.$n("real"), "1978/01/01");
      verifyEquals("1978/01/01", jq(birthdayBox.$n("real")).`val`());
      click(registerButton);
      waitResponse();
      verifyEquals("Hi, john: You are an adult.", jq(message).text());
    })
  }
}