/* F60_ZK_501Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Mar 21 16:37:25 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F60

import org.zkoss.zstl.ZTL4ScalaTestCase
import scala.collection.JavaConversions._
import org.junit.Test;
import org.zkoss.ztl.Element;
import org.zkoss.ztl.JQuery;
import org.zkoss.ztl.Tags;
import org.zkoss.ztl.util.Scripts;
import org.zkoss.ztl.Widget;
import org.zkoss.ztl.ZK;
import org.zkoss.ztl.ZKClientTestCase;
import java.lang._

/**
 * A test class for bug ZK-501
 * @author benbai
 *
 */
@Tags(tags = "F60-ZK-501.zul,F60,A,E,Messagebox,label")
class F60_ZK_501Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<zk>
    		<zscript>
    		session.setAttribute(org.zkoss.web.Attributes.PREFERRED_LOCALE, new Locale("en_US"));
    		</zscript>
			<html><![CDATA[
			<ul>
				<li>Click the Test button to open a message box.</li>
				<li>Then, you shall see the first button is labelled as "Yes, it is correct", and the second button is "No"</li>
			</ul>
			]]></html>
			
			<button label="Test" id="btn"
			onClick='Messagebox.show("Yes and No", "Test",
				new Messagebox.Button[] {Messagebox.Button.YES, Messagebox.Button.NO},
				new String[] {"Yes, it is correct"},
				Messagebox.INFORMATION, null, null)'/>
			
			</zk>

    }

    runZTL(zscript,
        () => {
        var btn: Widget = engine.$f("btn");
        var messagebox: JQuery = null;
        var msgBtnOne: JQuery = null;
        var msgBtnTwo: JQuery = null;

        click(btn);
        waitResponse();

        messagebox = jq(".z-messagebox-window");
        msgBtnOne = messagebox.find(".z-button:contains(Yes, it is correct)");
        msgBtnTwo = messagebox.find(".z-button:contains(No)");
        verifyTrue("you shall see the first button is labelled as \"Yes, it is correct\", and the second button is \"No\"",
                msgBtnOne.exists() && msgBtnTwo.exists()
                && msgBtnOne.offsetLeft() < msgBtnTwo.offsetLeft());
        
    }
   );

  }
}