/* B36_2874098Test.scala

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

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  * A test class for bug 2874098
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B36-2874098.zul,B,E,Databind,BI")
class B36_2874098Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
<?xml version="1.0" encoding="UTF-8"?>
<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" arg0="windowEdit" ?>
<window id="windowEdit">
<html><![CDATA[
<ol>
<li>key 'a' into first textbox.</li>
<li>key 'b' into second textbox.</li>
<li>Press "save" button</li>
<li>You shall see errorbox popup "All values are wrong: a" for the first textbox</li>
<li>If not, it is bug.</li>
</ol>
]]>
</html>
	<zscript><![CDATA[
    class MyBean {
  	  private String shortname;
  	  private String name;
  	  
  	  public void setShortname(String n) {
  		  this.shortname = n;
  	  }
  	  public String getShortname() {
  		  return this.shortname;
  	  }
  	  public void setName(String n) {
  		  this.name = n;
  	  }
  	  public String getName() {
  		  return this.name;
  	  }
    }
	MyBean mybean = new MyBean();
]]></zscript>

	<textbox id="tb" value="@{mybean.shortname,save-when='none'}" constraint="no empty" />
	<textbox id="tb2" value="@{mybean.name,save-when='none'}" constraint="no empty" />
	<button id="buttonSave" label="Save" >
		<attribute name="onClick">
	binder.setLoadOnSave(false);
	binder.saveAll();
	binder.loadAll();
	throw new WrongValueException(tb, "All values are wrong: " + mybean.shortname);
</attribute>
	</button>
</window>
    """

    runZTL(zscript,
      () => {
        waitResponse();
        //Text a on Text1
        var txt1 = jq("$tb");
        focus(txt1);
        waitResponse();
        keyPress(txt1, "a");
        waitResponse();

        //Text b on Text2
        var txt2 = jq("$tb2");
        focus(txt2);
        waitResponse();
        keyPress(txt2, "b");
        waitResponse();

        //Click save button
        var save = jq("$buttonSave");
        click(save);
        waitResponse();
        //Get errorbox exists
        var error = jq(".z-errorbox");
        verifyTrue(error.exists());
        verifyTrue(error.isVisible());
        //Error box message
        var em = "All values are wrong: a";
        //Verify error message
        verifyEquals(em, getText(error));

      });
  }

}