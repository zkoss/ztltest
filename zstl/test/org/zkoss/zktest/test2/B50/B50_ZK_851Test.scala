/* B50_ZK_851Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Feb 15 14:51:21 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

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
 * A test class for bug ZK-851
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-851.zul,B,M,Textbox,Popup")
class B50_ZK_851Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<zk xmlns="http://www.zkoss.org/2005/zul" xmlns:n="http://www.zkoss.org/2005/zk/native">
				<div>step 1: open Popup by click the first button</div>
				<div>step 2: edit text of the textbox</div>
				<div>step 3: close popup by clicking outside the popup area</div>
				<div>step 4: display value by click the second button, the value should changed</div>
				<window title="Hello World!!" border="normal" width="100%">
				
					<button id="btnOne" label="step 1: open Popup" popup="popup"/>
					<n:br/>
			
					<button id="btnTwo" label="step 4: display value">
						<attribute name="onClick">
							alert(input.getValue());
						</attribute>
					</button>
    				<n:br/>
    				<n:br/>
    				<n:br/>
    				<n:br/>
    				<n:br/>
    				<label id="lb" value="click area" />
					
					<popup id="popup">
						<label value="step 2: edit text"/>
						<n:br/>
						<textbox id="input" value="abc"/>
						<n:br/>
						<label value="step 3: close popup by clicking outside the popup area"/>
					</popup>
					
				</window>
			</zk>

    }

   runZTL(zscript,
        () => {
        var btnOne: Widget = engine.$f("btnOne");
        var btnTwo: Widget = engine.$f("btnTwo");
        var lb: Widget = engine.$f("lb");
        var input: Widget = engine.$f("input");

        click(btnOne);
        waitResponse();
        focus(input);
        sendKeys(input, "testtest");
        click(lb);
        waitResponse();
        click(btnTwo);
        waitResponse();
        verifyTrue("content should be updated (opera may error before fix merged)",
            jq(".z-messagebox:contains(testtest)").get(0).exists());
    }
   );
  }
}