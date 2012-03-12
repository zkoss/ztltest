/* B50_ZK_909Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Mar 12 14:10:41 CST 2012 , Created by benbai
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
 * A test class for bug ZK-909
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-909.zul,B,M,Textbox,InputWidget")
class B50_ZK_909Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
			<?xml version="1.0" encoding="UTF-8" ?>
			<zk>
				<div>step 1: click on save button without entering any data (you should see errorbox message)</div>
				<div>step 2: close errorbox1 and then errorbox2 (if you reverse the closing sequence then it will not cause this issue)</div>
				<div>step 3: enter some text into first textbox</div>
				<div>step 4: click on save again, the value of first textbox should not be cleared.</div>
				<vlayout>
					<hlayout>
						<label value="First textbox"></label>
						<textbox id="periodValue"></textbox>
					</hlayout>
					<hlayout>
						<label value="Second textbox"></label>
						<textbox id="periodValue1"></textbox>
					</hlayout>
					<button id="btnOne" label="save">
						<attribute name="onClick"><![CDATA[
							import java.util.ArrayList;
							
							import org.zkoss.lang.Strings;
							import org.zkoss.zk.ui.WrongValueException;
							import org.zkoss.zk.ui.WrongValuesException;
							
							ArrayList wve = new ArrayList();
							if(Strings.isEmpty(periodValue.getValue())) {
								wve.add(new WrongValueException(periodValue, "Empty not allowed 1"));
							}
							if(Strings.isEmpty(periodValue1.getValue())) {
								wve.add(new WrongValueException(periodValue1, "Empty not allowed 2"));
							}
							if (wve.size() > 0) {
								WrongValueException[] wvea = new WrongValueException[wve.size()];
								for (int i = 0; i < wve.size(); i++) {
									wvea[i] = (WrongValueException) wve.get(i);
								}
								throw new WrongValuesException(wvea);
							}			
						  ]]></attribute>
					</button>
				</vlayout>
			</zk>

    """


   runZTL(zscript, () => {
   			var (periodValue: Widget,
    	     periodValue1: Widget,
    	     btnOne: Widget) = (
    	        engine.$f("periodValue"),
    	        engine.$f("periodValue1"),
    	        engine.$f("btnOne")
    	    );
			def clickAndWait (wgt: org.zkoss.ztl.ClientWidget) {
   			    click(wgt);
   			    waitResponse();
   			}
   			def hasErrorbox (msg: String) {
   			    verifyTrue("Should appear errorbox contains "+msg,
   			        jq(".z-errbox:contains("+msg+")").exists());
   			}
   			def closeErrorbox (msg: String) {
   			    clickAndWait(jq(".z-errbox:contains("+msg+")").find(".z-errbox-close"));
   			}
   			waitResponse();
   			clickAndWait(btnOne);
   			hasErrorbox("Empty not allowed 1");
   			hasErrorbox("Empty not allowed 2");
   			closeErrorbox("Empty not allowed 1");
   			closeErrorbox("Empty not allowed 2");
   			sendKeys(periodValue.$n(), "123");
   			clickAndWait(btnOne);
   			verifyTrue("Textbox One should contains 123",
   			        "123".equals(periodValue.$n().get("value")));
   			hasErrorbox("Empty not allowed 2");
		})
  }
}