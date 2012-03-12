/* B50_ZK_918Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Mar 12 13:12:44 CST 2012 , Created by benbai
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
 * A test class for bug ZK-918
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-918.zul,B,M,Combobox,Sclass")
class B50_ZK_918Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
			<zk>
				<style>
					.mycombo .z-comboitem{
						background-color:red;
					}
					.mycomboTwo .z-comboitem{
						background-color:yellow;
					}
				</style>
				<combobox id="box" width="150px" mold="rounded" sclass="mycombo" >
				    <comboitem id="scf" label="Server+client Fusion" />
				    <comboitem id="pd" label="Pattern Driven" />
				    <comboitem id="ei" label="Enterprise Integration" />
				</combobox>
				<button id="btnOne" label="open" onClick='box.setOpen(true);' />
				<button id="btnTwo" label="change" onClick='box.setSclass("mycomboTwo");' />
				<button id="btnThree" label="show value">
					<attribute name="onClick">
						String cmd = "jq('$tbx')[0].value = jq('.z-comboitem').css('background-color')";
						Clients.evalJavaScript(cmd);
					</attribute>
				</button>
				<textbox id="tbx" />
			</zk>

    """


   runZTL(zscript, () => {
   			var (btnOne: Widget,
    	     btnTwo: Widget,
    	     btnThree: Widget,
    	     tbx: Widget) = (
    	        engine.$f("btnOne"),
    	        engine.$f("btnTwo"),
    	        engine.$f("btnThree"),
    	        engine.$f("tbx")
    	    );
			click(btnOne);
			waitResponse();
			click(btnThree);
			waitResponse();
			verifyTrue("Color is red",
			    jq(".z-comboitem").css("background-color").contains("255, 0, 0")
			    || jq(".z-comboitem").css("background-color").contains("red"));

			click(btnTwo);
			waitResponse();
			click(btnThree);
			waitResponse();
			verifyTrue("Color is yellow",
			    jq(".z-comboitem").css("background-color").contains("255, 255, 0")
			    || jq(".z-comboitem").css("background-color").contains("yellow"));
		})
  }
}