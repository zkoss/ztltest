/* B50_ZK_629Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Dec 06 10:31:06 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.{Element, Widget}
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug ZK-629
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-ZK-629.zul,A,E,Doublebox,Decimalbox,Doublespinner,Locale")
class B50_ZK_629Test extends ZTL4ScalaTestCase {

  def resetLocale(theme: String) {
    runZTL({
      """<zk>
				<zscript><![CDATA[
					Sessions.getCurrent().removeAttribute("px_preferred_locale");
				]]></zscript>
			</zk>"""
    },
      () => {
        refresh();
      })
  }

  def testNumberLocale() = {
    val zscript =
      """
			<zk>
    			<zscript><![CDATA[
    			Sessions.getCurrent().setAttribute("px_preferred_locale", new Locale("de","DE"));
    			]]></zscript>
				<div>Change browser locale to Germany for this test case.</div>
				<div>You should see the values in each input element "0,5" or "0,00...5", not "5".</div>
				<div>
					<doublebox id="db1" value="0.5" constraint="no negative" />
					<doublespinner id="db2" value="0.5" constraint="no negative" />
					<decimalbox id="db3" value="0.5" constraint="no negative" />
					<decimalbox id="db4" constraint="no negative" />
					<div>
						<decimalbox id="db5" width="500px" constraint="no negative" />
					</div>
				</div>
				<zscript>
					db4.value = new java.math.BigDecimal(0.5);
					db5.value = new java.math.BigDecimal("5E-50");
					
					db1.getValue();
					db2.getValue();
					db3.getValue();
					db4.getValue();
					db5.getValue();
				</zscript>
			</zk>

    """

    try {
      runZTL(zscript, () => {

        refresh();
        waitForPageToLoad("10000")
        waitResponse();

        runRawZscript(zscript.toString());
        waitResponse();
        var (db1: Widget,
        db2: Widget,
        db3: Widget,
        db4: Widget,
        db5: Widget) = (
          engine.$f("db1"),
          engine.$f("db2"),
          engine.$f("db3"),
          engine.$f("db4"),
          engine.$f("db5")
        );

        def checkValue(ele: Element) {
          verifyContains("You should see the values in each input element \"0,5\" or \"0,00...5\", not \"5\".",
            ele.attr("value"), "0,");
        }

        checkValue(db1.$n());
        checkValue(db2.$n("real"));
        checkValue(db3.$n());
        checkValue(db4.$n());
        checkValue(db5.$n());
      });
    } finally {
      resetLocale("breeze")
    }
  }
}