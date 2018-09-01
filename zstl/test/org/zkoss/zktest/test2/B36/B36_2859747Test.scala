/* B36_2859747Test.java

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
import org.zkoss.ztl.util._


class B36_2859747Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
Please click the "Text" header (it means upon the word.), and it should be sorted as well.
    <grid>
        <columns sizable="true">
            <column sort="auto">
                Text
            </column>
            <column label="Content"/>
        </columns>
        <rows>
            <row>
                <label value="File:"/>
                <textbox width="98%"/>
            </row>
            <row>
                <label value="Type:"/>
                <hbox>
                    <listbox rows="1" mold="select">
                        <listitem label="Java Files,(*.java)"/>
                        <listitem label="All Files,(*.*)"/>
                    </listbox>
                    <button label="Browse..."/>
                </hbox>
            </row>
            <row>
                <label value="Options:"/>
                <textbox rows="3" width="98%"/>
            </row>
        </rows>
    </grid>
</zk>


		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      clickAt(jq("@column:eq(0)"), "2,2")
      waitResponse()
      verifyEquals("File:", jq("@row:eq(0) @label").text())
      verifyEquals("Options:", jq("@row:eq(1) @label").text())
      verifyEquals("Type:", jq("@row:eq(2) @label").text())
    })
  }
}



