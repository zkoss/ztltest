/* B36_2728704Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2728704Test extends ZTL4ScalaTestCase {
  @Test
  def testsetSelect() = {
    var zscript =
      """
			<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?>
			<zk	xmlns:h="http://www.w3.org/1999/xhtml" xmlns:zk="http://www.zkoss.org/2005/zk">
				<html><![CDATA[
				<ol>
				<li>If you saw "FIRE onSelect event", then it is a bug.</li>
				<li>Press the button "change selected", and if you saw "FIRE onSelect event", then it is a bug.</li>
				<li>Otherwise, it is OK.</li>
				</ol>
				]]></html>
				<zscript><![CDATA[
					public class Person {
						private String _first;
						private String _last;
						
						public Person(String f, String l) {
							setFirstName(f);
							setLastName(l);
						}
						
						public String getFirstName() {
							return _first;
						}
						
						public void setFirstName(String f) {
							_first = f;
						}
						
						public String getLastName() {
							return _last;
						}
						
						public void setLastName(String l) {
							_last = l;
						}
					}
				
					List persons = new ArrayList(10);
					for(int j=0; j < 10; ++j) {
						persons.add(new Person("First"+j, "Last"+j));
					}
					Person selected = persons.get(0);
				]]></zscript>
				
				<button label="change Selected" onClick="((ListModelList)list.getModel()).set(0, selected)"/>
				<groupbox>
					<listbox id="list" model="@{persons}" selectedItem="@{selected}" rows="5"
													onSelect='alert("FIRE onSelect event")'>
					<listitem each="@{person}">
						<listcell label="@{person.firstName}"/>
						<listcell label="@{person.lastName}"/>
					</listitem>
					</listbox>
				</groupbox>
			
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val list = ztl$engine.$f("list")
    runZTL(zscript, () => {
      sleep(1000); //for DataBinding
      click(jq("@button"))
      waitResponse()
      verifyFalse(jq("div.z-window-modal").exists())
    })
  }
}



