/* B50_3166909Test.java

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


class B50_3166909Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			
<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit"?>


<div width="100%" xmlns="http://www.zkoss.org/2005/zul" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.zkoss.org/2005/zul http://www.zkoss.org/2005/zul/zul.xsd ">
<html><![CDATA[
<p>
1. You shall see two listboxes.<br/> 
2. The first one is Name-0 ~ Name-4, and Name-0 is selected<br/>
3. The second one is A ~ C, and A is selected.<br/>
4. Please select Name-0 to Name-3<br/>
5. You should not see any JavaScript error, and the last listbox selects the A.<br/>
</p>
]]></html>

	<zscript>
		<![CDATA[
			import org.zkoss.zktest.test2.BizService;
			
			BizService businessService = new BizService();
			void addNewRepository(){
				businessService.addNewRepository(parentsListBox.getModel());
			}
			
			void refreshFields(){
				System.out.println("refresh selected driver");
				binder.loadAll();
			}
			
			void refreshURL() {
				System.out.println("selecting driver");
			}
			
			void disable(boolean arg0) {
				System.out.println(arg0);
			}
			
		]]>
	</zscript>
	<vbox width="100%">
		<div>Repositories</div>
		<hbox >
			Select Repository:
			<listbox id="parentsListBox" mold="select" model="@{businessService.repositories}"
				selectedItem="@{businessService.repository}" onSelect="disable(businessService.getRepository()==null)">
				<listitem self="@{each=repository}">
					<listcell label="@{repository.name}" />
				</listitem>
			</listbox>
			<div>
				Cause Error:
				<button label="New" onClick="addNewRepository();refreshFields();" />
			</div>
		</hbox>
		<div>Driver</div>

		<hbox>
			Select Driver:
			<listbox id="driversListbox" model="@{businessService.drivers}" mold="select"
				selectedItem="@{businessService.repository.driver}" onSelect="refreshURL()">
                                 <listhead/>
				<listitem self="@{each=driver}" label="@{driver}" />
			</listbox>
		</hbox>
	</vbox>
</div>



		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val parentsListBox = ztl$engine.$f("parentsListBox")
    val driversListbox = ztl$engine.$f("driversListbox")
    runZTL(zscript, () => {
      sleep(1000); //for DataBinding
      select(parentsListBox, "Name-1")
      waitResponse()
      verifyEquals("B", jq(driversListbox).`val`())
      select(parentsListBox, "Name-2")
      waitResponse()
      verifyEquals("C", jq(driversListbox).`val`())
      select(parentsListBox, "Name-3")
      waitResponse()
      verifyEquals("A", jq(driversListbox).`val`())
      verifyFalse(jq(".z-error").exists())
    })
  }
}



