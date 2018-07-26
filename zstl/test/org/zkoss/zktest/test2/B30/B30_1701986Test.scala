/* B30_1701986Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1701986Test extends ZTL4ScalaTestCase {
  @Test
  def testConstraint() = {
    var zscript =
      """
			<window title="constraints depends on two component" border="normal">
				Bug 1701986: The error msgbox should disappear when error is corrected.
				<zscript>
					<![CDATA[
			Constraint ctt = new Constraint() {
				public void validate(Component comp, Object value)
						throws WrongValueException {		
						comp.setAttribute("dt", value);
						if (comp.getFellowIfAny("endDate") != null
								&& comp.getFellowIfAny("beginDate") != null) {
							Date beginValue = null;
							if (comp.getId().equals("beginDate")) {
								beginValue = (Date) value;
							} else {
								beginValue = (Date) ((Datebox) comp.getFellowIfAny("beginDate")).getAttribute("dt");
							}
							Date endValue = null;
							if (comp.getId().equals("endDate")) {
								endValue = (Date) value;
							} else {					
								endValue = (Date)((Datebox) comp.getFellowIfAny("endDate")).getAttribute("dt");
							}
							if (beginValue != null && endValue != null) {
								if (endValue.before(beginValue)) {
									throw new WrongValueException(comp, "ErrorMessage");
								} else {					
									long startM = beginValue.getTime();
									long endM = endValue.getTime();
									int days_plan = ((Long) ((endM - startM) / 1000 / 60 / 60 / 24))
											;
									((Label) comp.getFellowIfAny("days"))
											.setValue(new Integer(days_plan).toString());
									comp.getFellow("beginDate").clearErrorMessage();
									comp.getFellow("endDate").clearErrorMessage();
								}
							}
						}
				}
			};
			]]>
				</zscript>
				<grid width="90%">
					<rows>
						<row>			
							<label id="days" />
						</row>
						<row>
							start date box:
							<datebox id="beginDate" constraint="${ctt}"/>
						</row>
						<row>
							end date box:
							<datebox id="endDate" constraint="${ctt}" />
						</row>
					</rows>
				</grid>
				<label id = "lb" />
			<button id="submit" label="submit">
			<attribute name="onClick">
			lb.setValue((beginDate.getValue() == null ? "" : beginDate.getValue().toString())
			+(endDate.getValue() == null ? "" : endDate.getValue().toString()) );
			</attribute>
			</button>
			</window>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val days = ztl$engine.$f("days")
    val beginDate = ztl$engine.$f("beginDate")
    val endDate = ztl$engine.$f("endDate")
    val submit = ztl$engine.$f("submit")
    val lb = ztl$engine.$f("lb")
    runZTL(zscript, () => {
      click(jq("$beginDate").toWidget().$n("btn"))
      waitResponse()
      verifyNotEquals("none", jq(jq(".z-datebox:eq(0)").toWidget().$n("pp")).css("display"))
      click(jq(".z-calendar-weekday:eq(19)"))
      waitResponse()
      click(jq("$endDate").toWidget().$n("btn"))
      waitResponse()
      var pp1 = jq(".z-datebox:eq(1)").toWidget().$n("pp")
      verifyNotEquals("none", jq(pp1).css("display"))
      click(jq(pp1).find(".z-calendar-weekday:eq(14)"))
      waitResponse()
      click(jq("$submit"))
      waitResponse()
      verifyTrue(jq(".z-errorbox").exists())
    })
  }
}



