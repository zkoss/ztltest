/* F60_ZK_719Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Feb 20 09:40:10 CST 2012 , Created by benbai
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
 * A test class for bug ZK-719
 * @author benbai
 *
 */
@Tags(tags = "F60-ZK-719.zul,F60,A,E,Combobutton,Toolbar")
class F60_ZK_719Test extends ZTL4ScalaTestCase {
	
  @Test
  def testClick() = {
    val zscript = {
			<zk>
				<div>
					<div>1. You can see a combobutton in each toolbar, their size should similar to toolbarbutton.</div>
					<div>2. Click left button of combobutton one, the label 'message: ' should change to 'combobutton clicked.'.</div>
					<div>3. Click right button of combobutton one twice, the label should change to 'combobutton popup opened.' then 'combobutton popup closed.'.</div>
					<div>4. Test step 2 and step 3 with combobutton two.</div>
					<div>5. Also test F55-ZK-318.zul and make sure nothing strange.</div>
				</div>
				<button label="change to breeze">
					<attribute name="onClick">
						org.zkoss.zkplus.theme.Themes.setTheme(Executions.getCurrent(), "breeze"); // breeze
						Executions.sendRedirect(null);
					</attribute>
				</button>
				<button label="change to sapphire">
					<attribute name="onClick">
						org.zkoss.zkplus.theme.Themes.setTheme(Executions.getCurrent(), "sapphire");
						Executions.sendRedirect(null);
					</attribute>
				</button>
				<button label="change to silvertail">
					<attribute name="onClick">
						org.zkoss.zkplus.theme.Themes.setTheme(Executions.getCurrent(), "silvertail");
						Executions.sendRedirect(null);
					</attribute>
				</button>
				<window title="Toolbar window" border="normal" width="400px">
					<label id="lb" value="message: " />
					<toolbar>
						<toolbarbutton label="Left" image="/img/network.gif" />
						<space />
						<toolbarbutton id="tbbtnOne" label="Right" image="/img/network.gif"
							dir="reverse" />
						<combobutton id="cbbtnOne" label="combobutton one" image="/img/network.gif" mold="toolbar"
							onClick='lb.setValue("message: combobutton clicked.");'
							onOpen='lb.setValue("message: combobutton popup "+ (self.open? "opened." : "closed."));'>
							<popup id="ppOne">
								<vbox>
									<hbox>
										Search
										<textbox />
									</hbox>
									<listbox width="200px">
										<listhead>
											<listheader label="Name" />
											<listheader label="Description" />
										</listhead>
										<listitem>
											<listcell label="John" />
											<listcell label="CEO" />
										</listitem>
										<listitem>
											<listcell label="Joe" />
											<listcell label="Engineer" />
										</listitem>
										<listitem>
											<listcell label="Mary" />
											<listcell label="Supervisor" />
										</listitem>
									</listbox>
								</vbox>
							</popup>
						</combobutton>
					</toolbar>
					<toolbar orient="vertical">
						<button label="Left" image="/img/network.gif" width="125px" />
						<toolbarbutton id="tbbtnTwo" label="Right" image="/img/network.gif"
							dir="reverse" />
						<combobutton id="cbbtnTwo" label="combobutton two"
							onClick='lb.setValue("message: combobutton two clicked.");'
							onOpen='lb.setValue("message: combobutton two popup "+ (self.open? "opened." : "closed."));'
							dir="reverse" image="/img/network.gif" mold="toolbar">
							<popup id="ppTwo">
								<vbox>
									<hbox>
										Search
										<textbox />
									</hbox>
									<listbox width="200px">
										<listhead>
											<listheader label="Name" />
											<listheader label="Description" />
										</listhead>
										<listitem>
											<listcell label="John" />
											<listcell label="CEO" />
										</listitem>
										<listitem>
											<listcell label="Joe" />
											<listcell label="Engineer" />
										</listitem>
										<listitem>
											<listcell label="Mary" />
											<listcell label="Supervisor" />
										</listitem>
									</listbox>
								</vbox>
							</popup>
						</combobutton>
					</toolbar>
				</window>
			</zk>

    }

   runZTL(zscript,
        () => {
        var lb: Widget = engine.$f("lb");
        var tbbtnOne: Widget = engine.$f("tbbtnOne");
        var cbbtnOne: Widget = engine.$f("cbbtnOne");
        var tbbtnTwo: Widget = engine.$f("tbbtnTwo");
        var cbbtnTwo: Widget = engine.$f("cbbtnTwo");

        def clickThenVerify (wgt: org.zkoss.ztl.ClientWidget, content: String) {
            clickAndWait(wgt);
            verifyTrue("The value of message label should become "+content,
                jq(".z-label:contains("+content+")").exists());
        }
        def clickAndWait(wgt: org.zkoss.ztl.ClientWidget) {
            click (wgt);
            waitResponse();
        }
        
        verifyTrue("The size of combobutton (tbbtn mold) should similar to toolbarbutton",
            (jq(tbbtnOne).outerHeight(true) - jq(cbbtnOne).outerHeight(true)) <= 2
            && (jq(tbbtnTwo).outerHeight(true) - jq(cbbtnTwo).outerHeight(true)) <= 2);

        clickThenVerify (jq(cbbtnOne).toWidget().$n("real"), "combobutton clicked");
        clickThenVerify (jq(cbbtnOne).toWidget().$n("btn"), "combobutton popup opened");
        clickThenVerify (jq(cbbtnOne).toWidget().$n("btn"), "combobutton popup closed");

        clickThenVerify (jq(cbbtnTwo).toWidget().$n("real"), "combobutton two clicked");
        clickThenVerify (jq(cbbtnTwo).toWidget().$n("btn"), "combobutton two popup opened");
        clickThenVerify (jq(cbbtnTwo).toWidget().$n("btn"), "combobutton two popup closed");
    }
   );
  }
}