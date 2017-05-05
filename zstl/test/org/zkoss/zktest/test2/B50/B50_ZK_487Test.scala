/* B50_ZK_487Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Mar 28 18:37:33 CST 2012 , Created by benbai
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
 * A test class for bug ZK-487
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-487.zul,A,E,Groupbox,Caption")
class B50_ZK_487Test extends ZTL4ScalaTestCase {
	
  @Test
  def testClick() = {
    val zscript = """
			<zk>
			<html><![CDATA[
			<ol>
			<li>Open and clos the groupbox below, it should not be weird.</li>
			<li>Test with each theme.</li>
			</ol>
			]]></html>
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
				<hbox>
					<groupbox width="200px" height="200px" open="false" id="gb1">
						<caption image="/test2/img/inet.png" label="Testing Group Box" />
						<div style="background:#B8D335" vflex="1"> or vflex="1"</div>
					</groupbox>
					<groupbox width="200px" mold="3d" height="200px" open="false" id="gb2">
						<caption image="/test2/img/inet.png" label="Testing Group Box" />
						<div style="background:#B8D335" vflex="1"> or vflex="1"</div>
					</groupbox>
				</hbox>
			</zk>

    """
runZTL(zscript,
        () => {
        var gb1: Widget = engine.$f("gb1");
        var gb2: Widget = engine.$f("gb2");

        click(jq(gb1).find(".z-caption"));
        waitResponse();
        click(jq(gb2).find(".z-caption"));
        waitResponse();
        sleep(1000); // wait animation

        verifyEquals("Height should be 200", jq(gb1).height(), 200)
        verifyEquals("Height should be 200", jq(gb2).height(), 200);
    }
   );
  }
}