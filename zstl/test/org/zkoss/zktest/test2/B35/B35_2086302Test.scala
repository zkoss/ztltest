/* B35_2086302Test.scala

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
package org.zkoss.zktest.test2.B35

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Widget
import org.zkoss.ztl.Element


/**
 * A test class for bug 2086302
 * @author ldnigro
 *
 */
@Tags(tags = "B35-2086302.zul,C,E,Groupbox,Borderlayout")
class B35_2086302Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
<?xml version="1.0" encoding="UTF-8"?>

<!--
B35-2086302.zul

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Sep  1 18:22:30 TST 2008, Created by jumperchen
}}IS_NOTE

Copyright (C) 2008 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
-->
<window title="Groupbox test" width="100%">
Please click the "Open or Close GroupBox" button, and then the border layout should display well.
<groupbox id="gb2" width="500px" open="false">
<caption image="/test2/img/inet.png" label="Testing Group Box"/>
<borderlayout id="bl1" height="500px">
<north maxsize="300" size="50%" border="0" splittable="true"
collapsible="true">
<borderlayout id="bl2">
<west size="25%" border="none" flex="true" maxsize="250"
splittable="true" collapsible="true">
<div id="w2" style="background:#B8D335">
<label value="25%" style="color:white;font-size:50px"/>
</div>
</west>
<center border="none" flex="true">
<div id="c2" style="background:#E6D92C">
<label value="25%" style="color:white;font-size:50px"/>
</div>
</center>
<east  size="50%" border="none" flex="true">
<label id="e2" value="Here is a non-border"
style="color:gray;font-size:30px"/>
</east>
</borderlayout>
</north>
<center border="0">
<borderlayout id="bl3">
<west maxsize="600" size="30%" flex="true" border="0"
splittable="true" collapsible="true">
<div id="w3" style="background:#E6D92C">
<label value="30%" style="color:white;font-size:50px"/>
</div>
</west>
<center>
<label id="c3" value="Here is a border"
style="color:gray;font-size:30px"/>
</center>
<east size="30%" flex="true" border="0" collapsible="true">
<div id="e3" style="background:#B8D335">
<label value="30%" style="color:white;font-size:50px"/>
</div>
</east>
</borderlayout>
</center>
</borderlayout>
<vbox>TestVbox.</vbox>
</groupbox>
<button id="bt1" label="Open or Close GroupBox"
onClick="gb2.setOpen(!gb2.isOpen());"/>
</window>



    """

    runZTL(zscript,
        () => {
        	
        	//click open button
        	click(jq("$bt1"));
        	waitResponse(1000);
        	
        	var bl1=jq("$bl1");
        	verifyTrue(bl1.isVisible());
        	var bl1h=bl1.height();
        	var bl1w=bl1.width();
        	verifyTrue(bl1h==500);
        	
        	var bl2=jq("$bl2");
        	var bl2w=bl2.width();
        	
        	//Verify dimensions 25%, 25%, 50%
        	var w2w = jq("$w2").width().intValue();
        	verifyEquals((bl2w*.25).intValue(),w2w);
        	
        	var c2w=jq("$c2").width().intValue()+6;
        	verifyEquals((bl2w*.25).intValue(),c2w);
        	
        	var e2w=jq("$bl2 .z-east-body").width().intValue();
        	verifyEquals((bl2w*.5).intValue(),e2w);
        	
        	//Verify no border
        	verifyEquals(jq("$bl2 .z-east").css("border-top-width"),"0px");
        	verifyEquals(jq("$bl2 .z-east").css("border-left-width"),"0px");
        	verifyEquals(jq("$bl2 .z-east").css("border-right-width"),"0px");
        	verifyEquals(jq("$bl2 .z-east").css("border-bottom-width"),"0px");
        	
        	var bl3=jq("$bl3");
        	var bl3w=bl3.width();
        	
        	//Verify dimensions 30%, 40%, 30%
        	var w3w = jq("$w3").width().intValue();
        	verifyEquals((bl3w*.3).intValue(),w3w);
        	
        	var c3w=jq("$bl3 .z-center-body").width().intValue()+6;
        	verifyEquals((bl3w*.4).intValue(),c3w+1);
        	
        	//Verify border
        	verifyEquals(jq("$bl3 .z-center").css("border-top-width"),"1px");
        	verifyEquals(jq("$bl3 .z-center").css("border-left-width"),"1px");
        	verifyEquals(jq("$bl3 .z-center").css("border-right-width"),"1px");
        	verifyEquals(jq("$bl3 .z-center").css("border-bottom-width"),"1px");
        	
        	var e3w=jq("$e3 ").width().intValue();
        	verifyEquals((bl3w*.3).intValue(),e3w);
        	
        	//Vertical dimensions
        	
        	var bl2h=bl2.height().intValue();
        	var bl3h=bl3.height().intValue()+6;
        	         
        	verifyEquals(bl2h,(bl1h/2).intValue());
        	verifyEquals(bl3h,(bl1h/2).intValue());
        	
        }
    );
   }
}
