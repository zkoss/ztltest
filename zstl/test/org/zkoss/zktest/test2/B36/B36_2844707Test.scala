/* B36_2844707Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Nov 08 22:51:02 GFT 2011 , Created by ldnigro
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B36

import java.util.Calendar

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * A test class for bug 2844707
 * @author ldnigro
 *
 */
@Tags(tags = "B36-2844707.zul,A,E,Datebox,Calendar")
class B36_2844707Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """
<?xml version="1.0" encoding="UTF-8"?>

<!--
B36-2844707.zul

	Purpose:
		
	Description:
		
	History:
		Tue Oct 13 17:26:57     2009, Created by jumperchen

Copyright (C) 2009 Potix Corporation. All Rights Reserved.

-->
<zk>
Please select a date, and then select another month, and then it should be changed correctly.
<datebox format="d-MMM-yyyy"/>
</zk>

      """

    runZTL(zscript,
      () => {

        waitResponse();

        //Click date button
        var btn = jq(".z-datebox-btn");
        click(btn);
        waitResponse();

        //Click calendar day
        var day = jq(".z-calendar-wkday:eq(10)");
        focus(day);
        waitResponse();
        click(day);
        waitResponse();
        
        //Get date value
        var db=jq(".z-datebox-inp");
        var w1=getValue(db);
                
        //Next month (open calendar)
        var btn1 = jq(".z-datebox-btn");
        focus(btn1);
        waitResponse();
        click(btn1);
        waitResponse();
        var next = jq(".z-calendar-right-icon");
        focus(next);
        waitResponse();
        click(next);
        waitResponse();
        
        //Next date value
        var w2=getValue(db);
        
        //Get dates in Date format
        val format = new java.text.SimpleDateFormat("d-MMM-yyyy")
        var date2=format.parseObject(w2);
        var date1=format.parseObject(w1);
        
        // (date22 = date1 + 1 Month) must be equals to date2 
        val cal = Calendar.getInstance
        cal.setTime(date1.asInstanceOf[java.util.Date]);
        cal.add(Calendar.MONTH,1)
        val date22=cal.getTime();
        verifyEquals(date22,date2);
        
        

      });
  }
     
}