/* F55_ZK_12Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Mar 21 15:27:30 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F55

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
 * A test class for bug ZK-12
 * @author benbai
 *
 */
@Tags(tags = "F55-ZK-12.zul,F60,B,E,Checkbox,autodisable")
class F55_ZK_12Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
			<zk xmlns:w="client">
			<html><![CDATA[
			<ol>
			<li>Click 'ok' checkbox, the 'ok' checkbox should be disabled and enable again in a moment, the 'cancel' checkbox should be disabled.</li>
			<li>Click 'active cancel checkbox' button, the 'cancel' checkbox should be enabled.</li>
			<li>Click 'cancel' checkbox, the 'cancel' checkbox should be disabled and enable again in a moment, the 'ok' checkbox should be disabled.</li>
			<li>Click 'active ok checkbox' button, the 'ok' checkbox should be enabled.</li>
			</ol>
			]]></html>
				<vbox>
					<hbox>
						<checkbox id="ok" onClick="" label="ok" autodisable="self, +cancel">
							<attribute w:name="setDisabled">
								function (v) {
									if (v)
										zk.log(" ok is disabled");
									else
										zk.log(" ok is enabled");
									this.$setDisabled(v);
								}
							</attribute>
						</checkbox>
						<checkbox id="cancel" label="cancel" autodisable="self, +ok">
							<attribute w:name="setDisabled">
								function (v) {
									if (v)
										zk.log(" cancel is disabled");
									else
										zk.log(" cancel is enabled");
									this.$setDisabled(v);
								}
							</attribute>
						</checkbox>
					</hbox>
					<hbox>
						<button id="btnOne" label="active cancel checkbox">
							<attribute name="onClick">
								cancel.setDisabled(false);
							</attribute>
						</button>
						<button id="btnTwo" label="active ok checkbox">
							<attribute name="onClick">
								ok.setDisabled(false);
							</attribute>
						</button>
					</hbox>
				</vbox>
			</zk>

    """

    runZTL(zscript,
        () => {
        var ok: Widget = engine.$f("ok");
        var cancel: Widget = engine.$f("cancel");
        var btnOne: Widget = engine.$f("btnOne");
        var btnTwo: Widget = engine.$f("btnTwo");

        def clickAndVerify (wgt: org.zkoss.ztl.ClientWidget, delay: Int,
        	okEn: Boolean, okDis: Boolean, canEn: Boolean, canDis: Boolean) {
          var zklog: Element = null;
          var logContent: String = null;
          click(wgt);
          sleep(delay);

          zklog = jq("textarea").get(0);
          logContent = zklog.get("value");

          verifyTrue("The ok checkbox should "+(if (okEn) "" else " not")+"be enabled.",
              logContent.contains("ok is enabled") == okEn);
          verifyTrue("The ok checkbox should "+(if (okDis) "" else " not")+"be disabled.",
              logContent.contains("ok is disabled") == okDis);
          verifyTrue("The cancel checkbox should "+(if (canEn) "" else " not")+"be enabled.",
              logContent.contains("cancel is enabled") == canEn);
          verifyTrue("The cancel checkbox should "+(if (canDis) "" else " not")+"be disabled.",
              logContent.contains("cancel is disabled") == canDis);
          if (okEn && okDis)
            verifyTrue("the ok checkbox should enabled after disabled",
                logContent.lastIndexOf("ok is disabled") < logContent.lastIndexOf("ok is enabled"));
          if (canEn && canDis)
            verifyTrue("the cancel checkbox should enabled after disabled",
                logContent.lastIndexOf("cancel is disabled") < logContent.lastIndexOf("cancel is enabled"));
          zklog.eval("value=\"\"");
        }
        clickAndVerify(ok.$n("real"), 1500, true, true, false, true);
        clickAndVerify(btnOne, 600, false, false, true, false);
        clickAndVerify(cancel.$n("real"), 1500, false, true, true, true);
        clickAndVerify(btnTwo, 600, true, false, false, false);
    }
   );
   }
}