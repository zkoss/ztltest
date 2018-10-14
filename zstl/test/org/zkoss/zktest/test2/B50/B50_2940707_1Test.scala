/* B50_2940707Test.java

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


class B50_2940707_1Test extends ZTL4ScalaTestCase {
  @Test
  def testztl1() = {
    var zscript =
      """
				<vbox>
			    <html>
			        <![CDATA[
			            <ol>
			<li>Press button 1. You shall see the layout nothing changed.</li>
			<li>Press button 2. You shall see the layout nothing changed again.</li>
			<li>Press button 3. You shall see Item 2.2.1 removed and the "triangle" icon before Item 2.2
			removed.</li>
			<li>Reload this test case.</li>
			<li>Press button 4. You shall see Item 2.2.1 removed and the "triangle"
			icon before Item 2.2. removed.</li>
			<li>Select 2.1, 2.1.1 and 2.1.2</li>
			<li>Press button 2. You shall see the selection remains the same, i.e., all these three items being selected</li>
			<li>Unselect 2.1.1</li>
			<li>Press button 2 again. You shall see selection remains the same, i.e., 2.1 and 2.1.2 are both selected</li> 
			<li>Otherwise, it is a bug!</li>
			</ol>
			        ]]>
			    </html>
			    <tree id="tree" width="400px" rows="8" checkmark="true" multiple="true">
			        <treecols sizable="true">
			            <treecol label="Name" />
			            <treecol label="Description" />
			        </treecols>
			        <treechildren>
			            <treeitem>
			                <treerow>
			                    <treecell label="Item 1" />
			                    <treecell label="Item 1 description" />
			                </treerow>
			            </treeitem>
			            <treeitem>
			                <treerow>
			                    <treecell label="Item 2" />
			                    <treecell label="Item 2 description" />
			                </treerow>
			                <treechildren>
			                    <treeitem>
			                        <treerow>
			                            <treecell label="Item 2.1" />
			                        </treerow>
			                        <treechildren>
			                            <treeitem>
			                                <treerow>
			                                    <treecell label="Item 2.1.1" />
			                                </treerow>
			                            </treeitem>
			                            <treeitem>
			                                <treerow>
			                                    <treecell label="Item 2.1.2" />
			                                </treerow>
			                            </treeitem>
			                        </treechildren>
			                    </treeitem>
			                    <treeitem id="item221parent">
			                        <treerow>
			                            <treecell label="Item 2.2" />
			                        </treerow>
			                        <treechildren id="item221">
			                            <treeitem>
			                                <treerow>
			                                    <treecell label="Item 2.2.1" />
			                                </treerow>
			                            </treeitem>
			                        </treechildren>
			                    </treeitem>
			                </treechildren>
			            </treeitem>
			            <treeitem label="Item 3" />
			        </treechildren>
			    </tree>
			    <button id="btn1" label="1. invalidate item 2.2"
			onClick="item221parent.invalidate();"/>
			    <button id="btn2" label="2. invalidate item 2.1 and item 2.2"
			onClick="item221parent.parent.invalidate();"/>
			    <button id="btn3" label="3. detach item 2.2.1" onClick="item221.detach();"/>
			    <button id="btn4" label="4. detach item 2.2.1 and invalidate item 2.2"
			onClick="item221.detach();item221parent.invalidate();"/>
			</vbox>
			"""
    val ztl$engine = engine()
    val tree = ztl$engine.$f("tree")
    val item221parent = ztl$engine.$f("item221parent")
    val item221 = ztl$engine.$f("item221")
    val btn1 = ztl$engine.$f("btn1")
    val btn2 = ztl$engine.$f("btn2")
    val btn3 = ztl$engine.$f("btn3")
    val btn4 = ztl$engine.$f("btn4")
    runZTL(zscript, () => {
      click(btn4)
      waitResponse()
      verifyEquals(7, jq(".z-treechildren tr.z-treerow").length())
      verifyContains(jq(".z-treechildren tr.z-treerow:eq(6)").text(), "Item 3")
      click(jq(".z-treerow-checkbox:eq(2)"))
      waitResponse()
      click(jq(".z-treerow-checkbox:eq(3)"))
      waitResponse()
      click(jq(".z-treerow-checkbox:eq(4)"))
      verifyEquals(3, jq(".z-treerow-selected").length())
      click(btn2)
      waitResponse()
      verifyEquals(7, jq(".z-treechildren tr.z-treerow").length())
      verifyEquals(3, jq(".z-treerow-selected").length())
      verifyContains(jq(".z-treerow-selected:eq(0) .z-treecell").text(), "Item 2.1")
      verifyContains(jq(".z-treerow-selected:eq(1) .z-treecell").text(), "Item 2.1.1")
      verifyContains(jq(".z-treerow-selected:eq(2) .z-treecell").text(), "Item 2.1.2")
      click(jq(".z-treerow-checkbox:eq(2)"))
      waitResponse()
      verifyEquals(2, jq(".z-treerow-selected").length())
      click(btn2)
      waitResponse()
      verifyEquals(2, jq(".z-treerow-selected").length())
      verifyContains(jq(".z-treerow-selected:eq(0) .z-treecell").text(), "Item 2.1")
      verifyContains(jq(".z-treerow-selected:eq(1) .z-treecell").text(), "Item 2.1.2")
    })
  }
}



