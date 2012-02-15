/* F50_ZK_214Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Dec 13 17:22:07 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F50

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
 * A test class for bug ZK-214
 * @author benbai
 *
 */
@Tags(tags = "F50-ZK-214.zul,A,E,Databind,Composer")
class F50_ZK_214Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<zk>
			<html><![CDATA[
			1. Press the "submit" button. You should see the message as follows.<br/>
			[&lt;Textbox CA>, &lt;Textbox TX>, &lt;Textbox WA>] - [CA, TX, WA]
			]]></html> 
			<window style="margin: 0 auto" title="bindingValidation Test" apply="org.zkoss.zkplus.databind.AnnotateDataBindingComposer"> 
			 
			<zscript><![CDATA[ 
			public class User{  
				public String state;  
			 
				public String getState() { 
					return(state); 
				} 
			 
				public void setState(String st) { 
					state = st; 
				} 
			}  
			 
			List list = new LinkedList(); 
			u = new User(); 
			u.state="CA";  
			list.add(u);  
			u = new User(); 
			u.state="TX";  
			list.add(u);  
			u = new User(); 
			u.state="WA";  
			list.add(u);  
			 
			u = new User(); 
			u.state="ENTRY";  
			 
			public void validationForGrid(Event ev) {  
				System.out.println("validationForGrid called:"+ ev.getValue());  
			}  
			 
			public void validationForEntry(Event ev) {  
				System.out.println("validationForEntry called");  
			}  
			 
			]]></zscript>  
			<grid id="griid" width="415px" model="@{list}"> 
				<columns>  
					<column label="State" align="center" width="60px"/>  
				</columns>  
				<rows> 
					<row self="@{each=item}" align="center">
						<textbox id="@{item.state}" value="@{item.state, save-when='submit.onClick'}" onBindingSave="validationForGrid(event)"/>
					</row> 
				</rows> 
			</grid> 
			<textbox value="@{u.state}" onBindingSave="validationForEntry(event)"/>  
			 
			<button id="submit" label="submit"> 
			<attribute name="onBindingValidate"> 
				alert(event.references + " - " +event.values); 
			</attribute> 
			<attribute name="onClick"> 
				System.out.println("onClick() called"); 
			</attribute> 
			</button> 
			 
			</window> 
			
			<separator/>
			2.You shall see "Hello! ZK." --> Hello! ZK.
			<separator/>
			<window id="xwin" title="My First Window" border="normal" width="200px" 
				apply="org.zkoss.zktest.test2.MyComposer,org.zkoss.zkplus.databind.AnnotateDataBindingComposer">
			You shall see "Hello! ZK." --> <label value="@{xwin$MyComposer.hello}"/>
			</window>
			
			</zk>

    }


   runZTL(zscript, () => {
			var submit: Widget = engine.$f("submit");
   			var old: Integer = jq("body").find("div:contains([<Textbox CA>, <Textbox TX>, <Textbox WA>] - [CA, TX, WA])").length();
			click(submit);
			waitResponse();
			verifyTrue("should see the message [<Textbox CA>, <Textbox TX>, <Textbox WA>] - [CA, TX, WA]",
			    jq("body").find("div:contains([<Textbox CA>, <Textbox TX>, <Textbox WA>] - [CA, TX, WA])").length() > old);
		})
  }
}