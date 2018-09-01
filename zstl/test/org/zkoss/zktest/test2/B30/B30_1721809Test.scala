/* B30_1721809Test.java

  Purpose:

  Description:

  History:
    May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget

class B30_1721809Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    var zscript =
      """
      <window>
        button.onClick should always work.(Click more times)
        <separator />
        <button id="btn" label="test" onClick="label.value += &quot; click&quot;" />
        <label id="label" />
      </window>
    """
    val ztl$engine = engine()
    val btn = ztl$engine.$f("btn")
    val label = ztl$engine.$f("label")
    runZTL(zscript, () => {
      var value = "click"
      for (i <- 1 until 5) {
        click(btn)
        waitResponse()
        verifyEquals(getText(label), value)
        value += " click"
      }
    })
  }
}
