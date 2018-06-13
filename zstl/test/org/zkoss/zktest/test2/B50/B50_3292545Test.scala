/* B50_3292545Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3292545Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk xmlns:w="client">
	<html><![CDATA[
		<ol>
			<li>Check all of number are the same.</li>
			<li>Except latest five elements, they will less 2px.</li>
		</ol>
	]]></html>
	<zscript><![CDATA[
		import org.zkoss.zul.*;
		void doInit(Component comp) {
			Div div = new Div();
			div.setHflex("1");
			div.appendChild(new Label("0"));
			div.setWidgetListener("onBind", "this.firstChild.setValue(jq(this).width());");
			comp.appendChild(div);
		}
	]]></zscript>
	<vlayout>
		<hlayout onCreate="doInit(self);"><combobox mold="rounded" width="300px"/></hlayout>
		<hlayout onCreate="doInit(self);"><bandbox width="300px" mold="rounded"/></hlayout>
		<hlayout onCreate="doInit(self);"><datebox width="300px" mold="rounded"/></hlayout>
		<hlayout onCreate="doInit(self);"><spinner width="300px" mold="rounded"/></hlayout>
		<hlayout onCreate="doInit(self);"><timebox width="300px" mold="rounded"/></hlayout>
		<hlayout onCreate="doInit(self);"><doublespinner  mold="rounded" width="300px"/></hlayout>
		<hlayout onCreate="doInit(self);"><textbox width="300px" mold="rounded"/></hlayout>
		<hlayout onCreate="doInit(self);"><decimalbox width="300px" mold="rounded"/></hlayout>
		<hlayout onCreate="doInit(self);"><intbox width="300px" mold="rounded"/></hlayout>
		<hlayout onCreate="doInit(self);"><doublebox width="300px" mold="rounded"/></hlayout>
		<hlayout onCreate="doInit(self);"><longbox width="300px" mold="rounded"/></hlayout>
		<hlayout onCreate="doInit(self);"><combobox width="300px"/></hlayout>
		<hlayout onCreate="doInit(self);"><bandbox width="300px"/></hlayout>
		<hlayout onCreate="doInit(self);"><datebox width="300px"/></hlayout>
		<hlayout onCreate="doInit(self);"><spinner width="300px"/></hlayout>
		<hlayout onCreate="doInit(self);"><timebox width="300px"/></hlayout>
		<hlayout onCreate="doInit(self);"><doublespinner  width="300px"/></hlayout>
		<hlayout onCreate="doInit(self);"><textbox width="300px"/></hlayout>
		<hlayout onCreate="doInit(self);"><decimalbox width="300px"/></hlayout>
		<hlayout onCreate="doInit(self);"><intbox width="300px"/></hlayout>
		<hlayout onCreate="doInit(self);"><doublebox width="300px"/></hlayout>
		<hlayout onCreate="doInit(self);"><longbox width="300px"/></hlayout>
	</vlayout>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      verifyEquals(300, jq("@combobox:eq(0)").outerWidth())
      verifyEquals(300, jq("@bandbox:eq(0)").outerWidth())
      verifyEquals(300, jq("@datebox:eq(0)").outerWidth())
      verifyEquals(300, jq("@spinner:eq(0)").outerWidth())
      verifyEquals(300, jq("@timebox:eq(0)").outerWidth())
      verifyEquals(300, jq("@doublespinner:eq(0)").outerWidth())
      verifyEquals(300, jq("@textbox:eq(0)").outerWidth())
      verifyEquals(300, jq("@decimalbox:eq(0)").outerWidth())
      verifyEquals(300, jq("@intbox:eq(0)").outerWidth())
      verifyEquals(300, jq("@doublebox:eq(0)").outerWidth())
      verifyEquals(300, jq("@longbox:eq(0)").outerWidth())
      verifyEquals(300, jq("@combobox:eq(1)").outerWidth())
      verifyEquals(300, jq("@bandbox:eq(1)").outerWidth())
      verifyEquals(300, jq("@datebox:eq(1)").outerWidth())
      verifyEquals(300, jq("@spinner:eq(1)").outerWidth())
      verifyEquals(300, jq("@timebox:eq(1)").outerWidth())
      verifyEquals(300, jq("@doublespinner:eq(1)").outerWidth())
      verifyTolerant(300, jq("@textbox:eq(1)").outerWidth(), 2)
      verifyTolerant(300, jq("@decimalbox:eq(1)").outerWidth(), 2)
      verifyTolerant(300, jq("@intbox:eq(1)").outerWidth(), 2)
      verifyTolerant(300, jq("@doublebox:eq(1)").outerWidth(), 2)
      verifyTolerant(300, jq("@longbox:eq(1)").outerWidth(), 2)
    })
  }
}



