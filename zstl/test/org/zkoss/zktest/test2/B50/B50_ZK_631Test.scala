/* B50_ZK_631Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Dec 07 10:39:37 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug ZK-631
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-ZK-631.zul,B,E,Datebox,Constraint")
class B50_ZK_631Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
			<zk>
				<div>Type "abc" in datebox then press tab, you shoud see the message like</div>
				<div>You must specify a date, rather than abc. Format: yyyy/MM/dd.</div>
				<zscript><![CDATA[
					import org.zkoss.util.logging.Log;
					import org.zkoss.zk.ui.Component;
					import org.zkoss.zk.ui.WrongValueException;
					import org.zkoss.zul.CustomConstraint;
					import org.zkoss.zul.Datebox;
					import org.zkoss.zul.Label;
					import org.zkoss.zul.SimpleDateConstraint;
					
					class MyDateConstraint extends SimpleDateConstraint implements CustomConstraint{
						
						private static Log log = Log.lookup(MyDateConstraint.class);
						private Label errfld;
					
						public MyDateConstraint(Label errlbl, int flags) {
							super(flags);
							errfld = errlbl;
						}
						
						public void showCustomError(Component comp, WrongValueException ex) {
							System.out.println("showCustomError");
							if (ex != null) {
								log.debug("WrongValueException Message: " + ex.getMessage());
								errfld.setValue(ex.getMessage());
								errfld.setVisible(true);
							} else {
								log.debug("No exception");
								if (comp instanceof Datebox) {
									log.debug("datebox error message is: "
											+ ((Datebox) comp).getErrorMessage());
								} else
									log.debug("comp is: " + comp.getClass().getName());
					
								errfld.setVisible(false);
							}
						}
					}
					public void setCustomConstraint (Datebox dob, Label doberr) {
						dob.setConstraint(new MyDateConstraint(doberr, MyDateConstraint.STRICT | MyDateConstraint.SERVER | MyDateConstraint.NO_FUTURE| MyDateConstraint.NO_TODAY));
					}
				]]></zscript>
				<window id="win">
					<attribute name="onCreate">
						setCustomConstraint(dob, doberr);
					</attribute>
					<datebox id="dob" width="200px" visible="true"
						format="yyyy/MM/dd" lenient="false" locale="en_US">
						<attribute name="onChange">
							if (self.getValue() != null)
								dateValue.setValue(self.getValue().toString());
							else
								dateValue.setValue(null);
						</attribute>
					</datebox>
					<label id="doberr"  value="error message" />
					<div />
					<label id="dateValue" />
				</window>
			</zk>

    """
    runZTL(zscript, () => {
      var dob: Widget = engine.$f("dob");
      var doberr: Widget = engine.$f("doberr");
      sendKeys(jq(dob.$n()).find("input"), "abc");
      click(doberr);
      waitResponse();
      var errMsg: String = doberr.$n().get("innerHTML");
      verifyContains("should display custom error about date format",
        errMsg, "abc")
      verifyContains("should display custom error about date format",
        errMsg, "yyyy/MM/dd")
    })
  }
}