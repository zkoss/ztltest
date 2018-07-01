package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  *
  * @author Christopher
  */
@Tags(tags = "B80-ZK-2906.zul")
class B80_ZK_2906Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        val cb = jq(".z-chosenbox-input")
        // click on chosenbox to focus
        click(cb)
        waitResponse(true)

        // type the special characters that will be escaped
        typeKeys(cb, "'`&<>\"")
        waitResponse(true)

        val itemText = jq(".z-chosenbox-empty span").text()
        // check the content of the first item is '`&<>"'
        verifyEquals("expecting '`&<>\", got: " + itemText, "Create new contact ''`&<>\"'", itemText)
      })
  }
}