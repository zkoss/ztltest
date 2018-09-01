/* B30_1941947Test.java

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


class B30_1941947Test extends ZTL4ScalaTestCase {
  @Test
  def testBinding() = {
    var zscript =
      """
			<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?>
			<window width="500px">
			<html><![CDATA[
			<p>
			1. You should see "Cat1" in first textbox and followed by three same
			listboxes (Name0 ~ Name3).<br/>
			2. Change "Cat1" to "Cat2" and press "tab" key to tab away the
			textbox.<br/>
			3. It is a BUG if you see an alert window complains <br/>
			"Cannot find associated CollectionItem: &lt;Listbox ...>"<br/>
			4. It is OK if no such alert window.<br/>
			</p>  
			]]></html>
			<zscript><![CDATA[
			public class Persons {
			    private String category = "Cat1";
			    private String[] names = new String[4];
			    public Persons() {
			        for (int j = 0; j < names.length; ++j)
			            names[j] = "Name"+j;
			    }
			    public String[] getNames() {
			        return this.names;
			    }
			    public void setCategory(String cat) {
			        this.category = cat;
			    }
			    public String getCategory() {
			        return this.category;
			    }
			}
			Persons persons = new Persons();
			Object[] manypersons = new Object[3];
			]]></zscript>
			
			    <textbox id="cateTxtbox" rows="1" cols="25" sclass="reg"
			value="@{persons.category}"/>
			    <grid id="commodityItemsGrid" height="200px" model="@{manypersons}">
			        <rows>
			            <row self="@{each=count}">
			                <vbox>
			                    <listbox mold="select" model="@{persons.names}">
			                        <listitem self="@{each=name}" label="@{name}" />
			                    </listbox>
			                </vbox>
			            </row>
			        </rows>
			    </grid>
			</window>
		"""
    val ztl$engine = engine()
    val cateTxtbox = ztl$engine.$f("cateTxtbox")
    val commodityItemsGrid = ztl$engine.$f("commodityItemsGrid")
    runZTL(zscript, () => {
      sleep(1000); //for DataBinding
      typeKeys(cateTxtbox, "Cat2");
      if (!jq(".z-window-highlighted").exists() && !jq(".z-window-modal").exists()) {
        verifyTrue(true)
      } else {
        verifyTrue(false)
      }
    })
  }
}



