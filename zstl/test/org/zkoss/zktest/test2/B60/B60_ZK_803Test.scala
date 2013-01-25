package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B60-ZK-803.zul")
class B60_ZK_803Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
        <div>1. Select first item and second item.</div>
        <div>2. Drag first item, you should see two selected items dragged.</div>
        <div>3. Drag third item, you should see only third item dragged</div>
        <listbox width="200px" multiple="true" checkmark="true">
          <listhead>
            <listheader label="name" sort="auto"/>
            <listheader label="gender" sort="auto"/>
          </listhead>
          <listitem draggable="true">
            <listcell label="Mary"/>
            <listcell label="FEMALE"/>
          </listitem>
          <listitem draggable="true">
            <listcell label="John"/>
            <listcell label="MALE"/>
          </listitem>
          <listitem draggable="true">
            <listcell label="Jane"/>
            <listcell label="FEMALE"/>
          </listitem>
          <listitem draggable="true">
            <listcell label="Henry"/>
            <listcell label="MALE"/>
          </listitem>
        </listbox>
      </zk>"""

    runZTL(zscript,
      () => {
        val mary = jq(".z-listitem:contains(Mary)")
        val john = jq(".z-listitem:contains(John)")
        val jane = jq(".z-listitem:contains(Jane)")

        // step 1
        click(mary)
        waitResponse()
        click(john)
        waitResponse()
        val position = "2,2"

        // step 2
        mouseMoveAt(mary, position)
        waitResponse

        mouseDownAt(mary, position)
        waitResponse

        mouseMoveAt(john, position)
        waitResponse

        verifyTrue("should see two selected items dragged.", jq(".z-drop-ghost .z-drop-cnt:contains(Mary)").exists())
        verifyTrue("should see two selected items dragged.", jq(".z-drop-ghost .z-drop-cnt:contains(John)").exists())

        mouseUpAt(john, position)
        waitResponse

        // step 3
        mouseMoveAt(jane, position)
        waitResponse

        mouseDownAt(jane, position)
        waitResponse

        mouseMoveAt(john, position)
        waitResponse

        val drop = jq(".z-drop-ghost .z-drop-cnt")
        verifyEquals("should see only third item dragged", drop.length(), 1)
        verifyTrue("should see only third item dragged", drop.text().contains("Jane"))

      })

  }
}
