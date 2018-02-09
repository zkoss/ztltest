package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase

class B30_1813518Test extends ZTL4ScalaTestCase {
  def testClick() = {
    runZTLinAction("test2/B30-1813518.zhtml", () => {
      var borderCss = jq("@rows:eq(0) td").eval("get(0).style.border")
      verifyTrue(borderCss.equals("1px solid blue") || borderCss.equals("1px solid #0000ff") || borderCss.equals("blue 1px solid"))
      verifyTrue("rgb(51, 51, 51)#333333".contains(jq("@rows:eq(0) td").css("color")))
      verifyTrue("rgb(227, 235, 246)#e3ebf6".contains(jq("@rows:eq(0) td").css("backgroundColor")))
      verifyEquals("", jq("@rows:eq(1) td").eval("get(1).style.border"))
      var color = jq("@rows:eq(1) td").css("color")
      verifyTrue(color.contains("rgba(0, 0, 0, 0.9") || color.contains("#000000"))
      println(jq("@rows:eq(1) td").css("color"))
      verifyTrue("transparent|rgb(255, 255, 255)|rgba(0, 0, 0, 0)|#ffffff".contains(jq(
        "@rows:eq(1) td").css("backgroundColor")))
    })
  }
}