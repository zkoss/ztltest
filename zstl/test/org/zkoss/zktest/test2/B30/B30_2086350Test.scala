/* B30_2086350Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_2086350Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
Please click the "Click Me!" header of the nested listbox, and then no error appears.(That is correct)
<listbox width="400px" onSelect='alert(self.selectedItem.uuid);'>
	<listhead sizable="true">
		<listheader label="name" sort="auto" />
		<listheader label="gender" sort="auto" />
	</listhead>
	<listitem>
		<listcell>
			<listbox width="250px">
				<listhead sizable="true">
					<listheader id="lh" label="Click Me!" sort="auto" />
					<listheader label="gender" sort="auto" />
				</listhead>
				<listitem>
					<listcell label="Mary" />
					<listcell label="FEMALE" />
				</listitem>
				<listitem>
					<listcell label="John" />
					<listcell label="MALE" />
				</listitem>
				<listitem>
					<listcell label="Jane" />
					<listcell label="FEMALE" />
				</listitem>
				<listitem>
					<listcell label="Henry" />
					<listcell label="MALE" />
				</listitem>
			</listbox>

		</listcell>
		<listcell label="FEMALE" />
	</listitem>
	<listitem>
		<listcell label="John" />
		<listcell label="MALE" />
	</listitem>
	<listitem>
		<listcell label="Jane" />
		<listcell label="FEMALE" />
	</listitem>
	<listitem>
		<listcell label="Henry" />
		<listcell label="MALE" />
	</listitem>
</listbox>
</zk>

		"""
    val ztl$engine = engine()
    val lh = ztl$engine.$f("lh")
    runZTL(zscript, () => {
      click(jq("$lh"))
      verifyFalse(jq(".z-error").exists())
    })
  }
}



