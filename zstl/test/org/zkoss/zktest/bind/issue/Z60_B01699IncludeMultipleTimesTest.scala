/* Z60_B01699IncludeMultipleTimesTest.scala

	Purpose:
		
	Description:
		
	History:
		Jan 15, 2014 Created by Kuro Chung

Copyright (C) 2014 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * @author kuro
 */
@Tags(tags = "zbind")
class Z60_B01699IncludeMultipleTimesTest extends ZTL4ScalaTestCase {
  
  def testArg() = {
    val zul = {
      <include src="/bind/issue/B01699IncludeMultipleTimes.zul"/>
    }
    
    runZTL(zul, () => {
      val lab1 = jq("$lb1").toWidget();
      val lab2 = jq("$lb2").toWidget();
      val btn = jq("$btn").toWidget();
      
      verifyEquals("Foo_1", lab1.get("value"));
      verifyEquals("Bar_1", lab2.get("value"));
      
      click(btn);
      waitResponse();
     
      val lab3 = jq("$lb1").toWidget();
      val lab4 = jq("$lb2").toWidget();
      
      verifyEquals("FOO_1", lab3.get("value"));
      verifyEquals("BAR_1", lab4.get("value"));
      
    })

  }

}