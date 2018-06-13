/* B50_3025674Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3025674Test extends ZTL4ScalaTestCase {
  @Test
  def testreloadMessages() = {
    var zscript =
      """
			<zk>
				<vbox>
					<listbox id="selectList" rows="1" mold="select">
						<listhead id="listhead" >
							<listheader label="column1"/>
						</listhead>
						<auxhead id="auxhead" >
							<auxheader label="test"/>
						</auxhead>
						<listitem>
							<listcell label="cell 1"></listcell>
						</listitem>
						<listitem>
							<listcell label="cell 2"></listcell>
						</listitem>
						<listitem>
							<listcell label="cell 3"></listcell>
						</listitem>
					</listbox>	
				</vbox>
				<label id="msg" style="color: red;" xmlns:w="http://www.zkoss.org/2005/zk/client">
					<attribute w:name="onBind">
						var listhead = jq('.z-listhead')[0],
							auxhead = jq('.z-auxhead')[0];
						if (listhead || auxhead)
							this.setValue("Listbox should not render Listhead when mold is select");
					</attribute>
				</label>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val selectList = ztl$engine.$f("selectList")
    val listhead = ztl$engine.$f("listhead")
    val auxhead = ztl$engine.$f("auxhead")
    val msg = ztl$engine.$f("msg")
    runZTL(zscript, () => {
      verifyEquals(msg.get("value"), "")
    })
  }
}



