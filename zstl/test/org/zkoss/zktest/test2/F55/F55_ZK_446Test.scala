/* F55_ZK_446Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Mar 21 15:04:14 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F55

import java.lang._

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug ZK-446
  *
  * @author benbai
  *
  */
@Tags(tags = "F55-ZK-446.zul,F60,A,E,InputElement")
class F55_ZK_446Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
			<zk>
				<div><![CDATA[
					Test code: 
					<textbox instant="true" constraint="/[a-z]*/" />
				]]></div>
				<div>
					1. The onChange event should be fire upon typing (like onChanging).
				</div>
				<div>
					2. Both values (textbox and event) should be identical to the one in the textbox input.
				</div>
				<div>
					3. Value setting should respect constraint validation.
				</div>
				<div height="30px" />
				Input:
				<textbox id="tbx" instant="true" constraint="/[a-z]*/">
					<attribute name="onChange">
						lb.value = self.value;
						lb2.value = event.value;
						ib.value++;
					</attribute>
				</textbox>
				<div height="30px" />
				<div>
					onChange fired: <intbox id="ib" readonly="true" value="0" />
				</div>
				<div>
					Textbox value: <label id="lb" />
				</div>
				<div>
					Event value: <label id="lb2" />
				</div>
			</zk>

    """
    runZTL(zscript,
      () => {
        var tbx: Widget = engine.$f("tbx");
        var ib: Widget = engine.$f("ib");
        var lb: Widget = engine.$f("lb");
        var lb2: Widget = engine.$f("lb2");

        def inputAndCheck(value: String, fired: String, shouldError: Boolean) {
          sendKeys(tbx, value);
          sleep(500);
          verifyEquals("value should be identical",
            lb.$n().attr("innerHTML"), lb2.$n().attr("innerHTML"))
          verifyEquals("event should be fired if no error",
            ib.$n().attr("value"), fired)
          verifyTrue(jq(".z-errorbox").exists() == shouldError);
        }

        inputAndCheck("ab", "1", false);
        inputAndCheck("cde", "2", false);
        inputAndCheck("A", "2", true);
        evalScript(tbx.$n() + ".value=''")
        inputAndCheck("bc", "3", false);
        inputAndCheck("123", "3", true);
      }
    );
  }
}