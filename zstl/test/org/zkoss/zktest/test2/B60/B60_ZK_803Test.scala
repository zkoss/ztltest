package org.zkoss.zktest.test2.B60

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B60-ZK-803.zul")
class B60_ZK_803Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
        val mary = jq(".z-listcell:contains(Mary)")
        val john = jq(".z-listcell:contains(John)")
        val jane = jq(".z-listcell:contains(Jane)")

        // step 1
        click(mary)
        waitResponse()
        click(john)
        waitResponse()

        // step 2
        dragAndDrop(mary, "120,20")
        waitResponse()

        verifyContains("should see two selected items dragged.", getZKLog(), "Mary")
        verifyContains("should see two selected items dragged.", getZKLog(), "John")
        closeZKLog()
        waitResponse()
        // step 3
        dragAndDrop(jane, "120,20")
        waitResponse()
        verifyContains("should see only third item dragged.", getZKLog(), "Jane")
        verifyContains("should see only third item dragged.", getZKLog(), ">>>1")

      })

  }
}
