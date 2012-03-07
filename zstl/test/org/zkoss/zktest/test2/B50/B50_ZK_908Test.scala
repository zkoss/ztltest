/* B50_ZK_908Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Mar 07 14:50:14 CST 2012 , Created by benbai
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
 * A test class for bug ZK-908
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-908.zul,B,M,Textbox,InputWidget")
class B50_ZK_908Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
			<zk>
				<div>Test Window One</div>
				<div>1. Click 'save' button, you should see two error box.</div>
				<div>2. Close the first error box then close the second error box.</div>
				<div>3. Input some value into First textbox then click 'save' button again.</div>
				<div>4. The value of First textbox should not be cleared.</div>
				<div height="10px"></div>
				<div>Test Window Two</div>
				<div>1. Input -1 in Intbox One then click outside, you should see an error box.</div>
				<div>2. Input -1 in Intbox Two then click outside, you should see an error box.</div>
				<div>3. Click 'set -1' button, the error box of Intbox Two should not disappeared.</div>
				<div>4. Click 'set 1' button, the error box of Intbox Two should disappeared.</div>
				<div>5. Input -1 in Intbox Three then click outside, you should see message 'Only positive number or zero is allowed'.</div>
				<div>6. Click 'set 1 two' button, the message above should disappeared.</div>
				<div>7. Input -1 in Intbox Four then click outside, you should see an error box.</div>
				<window title="Window One" border="normal">
					<grid>
						<columns>
							<column width="150px" />
						</columns>
						<rows>
							<row>
								<label value="First textbox"></label>
								<textbox id="tbOne"></textbox>
							</row>
							<row>
								<label value="Second textbox"></label>
								<textbox id="tbTwo"></textbox>
							</row>
							<row>
								<button id="btnOne" label="save">
									<attribute name="onClick"><![CDATA[
										if ("".equals(tbOne.getValue())) {
											tbOne.setErrorMessage("Empty not allowed in 1");
										}
										if ("".equals(tbTwo.getValue())) {
											tbTwo.setErrorMessage("Empty not allowed in 2");
										}
									]]></attribute>
								</button>
							</row>
						</rows>
					</grid>
				</window>
				<window title="Window Two" border="normal">
					<script>
					zk.load('zul.inp', function () {
						ClientServerConstraint = zk.$extends(zul.inp.SimpleConstraint, {
							serverValidate: true
						});
					});
					</script>
					<zscript><![CDATA[
					public class MyConstraint extends SimpleConstraint implements CustomConstraint {
						public MyConstraint(int flags) {
							super(flags);
						}
						public void showCustomError(Component comp, WrongValueException ex) {
							comp.getFellow("errlb").setValue(ex != null ? ex.getMessage(): "");
						}
					}
					MyConstraint nes = new MyConstraint(MyConstraint.NO_NEGATIVE);
					
					public class ClientServerConstraint extends SimpleConstraint {
						public ClientServerConstraint() {
							super(NO_NEGATIVE);
						}
						public void validate(Component comp, Object value)
						throws WrongValueException {
							super.validate(comp, value);
							if (value != null && (value.intValue() & 1) != 0)
								throw new WrongValueException(comp, "Only even numbers are allowed, not "+value);
						}
						public String getClientConstraint() {
							return "new ClientServerConstraint('no negative');";
						}
					};
					ClientServerConstraint csc = new ClientServerConstraint();
					]]></zscript>
					
					<grid>
					<rows>
						<row>Intbox One: No negative: <intbox id="ibOne" constraint="no negative"/></row>
						<row>Intbox Two: No negative (custom message): <intbox id="ibTwo" constraint="no negative:Negative? Not possible"/>
						<button id="btnTwo" label="set -1" onClick="ibTwo.setValue(-1)" style="margin-left: 30px" />
						<button id="btnThree" label="set 1" onClick="ibTwo.setValue(1)"/>
						</row>
						<row>
						Intbox Three: Custom error display (no negative):
						<intbox id="ibThree" constraint="${nes}"/>
						<label id="errlb"/>
						<button id="btnFour" label="set 1 two" onClick="ibThree.setValue(1)"/>
						</row>
						<row>
						Intbox Four: Client+Server (no negative, no odd number):
						<intbox id="ibFour" constraint="${csc}"/>
						</row>
					</rows>
					</grid>
				</window>
    			<label id="lbTwo" value="outside label" />
			</zk>

    """


   runZTL(zscript, () => {
   			var (tbOne: Widget, tbTwo: Widget, ibOne: Widget, ibTwo: Widget,
   					ibThree: Widget, ibFour: Widget, btnOne: Widget, btnTwo: Widget,
   					btnThree: Widget, btnFour: Widget, errlb: Widget, lbTwo: Widget) =
   				(engine.$f("tbOne"), engine.$f("tbTwo"), engine.$f("ibOne"), engine.$f("ibTwo"),
    	        	engine.$f("ibThree"), engine.$f("ibFour"), engine.$f("btnOne"), engine.$f("btnTwo"),
    	        	engine.$f("btnThree"), engine.$f("btnFour"), engine.$f("errlb"), engine.$f("lbTwo")
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
   			clickAndWait(btnOne);
   			hasErrorbox("Empty not allowed in 1");
   			hasErrorbox("Empty not allowed in 2");
   			closeErrorbox("Empty not allowed in 1");
   			closeErrorbox("Empty not allowed in 2");
   			sendKeys(tbOne.$n(), "123");
   			clickAndWait(btnOne);
   			verifyTrue("Textbox One should contains 123",
   			        "123".equals(tbOne.$n().get("value")));
   			hasErrorbox("Empty not allowed in 2");

   			sendKeys(ibOne.$n(), "-1");
   			clickAndWait(lbTwo);
   			verifyTrue("Should appear one more errorbox",
   			        jq(".z-errbox").length() == 2);
   			sendKeys(ibTwo.$n(), "-1");
   			clickAndWait(lbTwo);
   			verifyTrue("Should appear one more errorbox",
   			        jq(".z-errbox").length() == 3);
   			clickAndWait(btnTwo);
   			verifyTrue("Error box not disappear",
   			        jq(".z-errbox").length() == 3);
   			clickAndWait(btnThree);
   			verifyTrue("Error box three disappeared",
   			        jq(".z-errbox").length() == 2);
   			sendKeys(ibThree.$n(), "-1");
   			clickAndWait(lbTwo);
   			verifyTrue("Label shows error message",
   			        jq(".z-label").get(0).get("innerHTML").length() > 5);
   			sendKeys(ibFour.$n(), "-1");
   			clickAndWait(lbTwo);
   			verifyTrue("Should appear one more errorbox",
   			        jq(".z-errbox").length() == 3);
		})
  }
}