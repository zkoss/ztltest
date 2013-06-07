/* B36_2884058Test.scala

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

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * A test class for bug 2884058
 * @author ldnigro
 *
 */
@Tags(tags = "B36-2884058.zul,A,E,Datebox,Calendar")
class B36_2884058Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """
<?xml version="1.0" encoding="UTF-8"?>

<!--
B36-2884058.zul

	Purpose:
		
	Description:
		
	History:
		Fri Oct 23 14:30:13 TST 2009, Created by sam

Copyright (C) 2009 Potix Corporation. All Rights Reserved.

-->
<window>
<vbox>
<label>Error in calendar component in IE and Opera.</label>
<label>1.Click on datebox's icon, it will popop a Calendar</label>
<label>2.Compare these 2 Calendar, look the same is correct</label>
</vbox>
<hbox>
<datebox/>
<separator orient="vertical" width="50px"/>
<calendar/>
</hbox>
</window>
    """

    runZTL(zscript,
      () => {

        waitResponse();

        //Click date button
        var btn = jq(".z-datebox-icon");
        click(btn);
        waitResponse();
        
        //Get Calendars 
        var c0=jq(".z-calendar:eq(0)");
        var c1=jq(".z-calendar:eq(1)");
        
        //Get Calendars HTML
        var html0=c0.text();
        var html1=c1.text();
        
        //Verify equals
        verifyEquals(html0,html1);
        
      });
  }
     
}