/* B35_2073417Test.scala

	Purpose:
		
	Description:
		
	History:
		Tue Dec 13 11:54:13 TST 2011, Created by jumperchen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B35

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;

/**
 * 
 * @author jumperchen
 */
@Tags(tags = "B35-2073417.zul,A,E,Button,VisionTest")
class B35_2073417Test extends ZTL4ScalaTestCase {
	def testCase() = {
		val zscript = {"""
		<?page id="testZul" title=" New ZUL Title" cacheable="false" 
	language="xul/html" zscriptLanguage="Java" contentType="text/html;charset=UTF-8"?>
<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit"?>
<zk xmlns="http://www.zkoss.org/2005/zul" xmlns:h="http://www.w3.org/1999/xhtml" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://www.zkoss.org/2005/zul/zul.xsd">
  <window title="Test Buttons in various components." border="normal" width="400px">
    <hbox>Buttons in listbox: Note: Button should look appropriate and tidy.

<listbox id="box" width="250px">
        <listhead sizable="true">
          <listheader label="name" sort="auto"/>
          <listheader label="gender" sort="auto"/>
        </listhead>
        <listitem>
          <listcell>
            <button id="btn1" label="ClickMe" onClick='self.setLabel("Tested OK")'/>
          </listcell>
          <listcell label="FEMALE">
            <button id="btn2" label="ClickMe" onClick='self.setLabel("Tested OK")'/>
          </listcell>
        </listitem>
      </listbox>
    </hbox>
  </window>
</zk>

		"""}
		runZTL(zscript, () => {
			verifyImage()
			click(jq("$btn1"))
			click(jq("$btn2"))
			waitResponse
			verifyImage()
		})
	}
}
