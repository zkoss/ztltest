package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase

class B30_1813518Test extends ZTL4ScalaTestCase {
  def testClick() = {
    runZTLinAction("test2/B30-1813518.zhtml", () => {
      var borderCss = jq("@rows:eq(0) td").eval("get(0).style.border")
      verifyContains("1px solid blue1px solid #0000ffblue 1px solid", borderCss)
      verifyContains("rgb(51, 51, 51)#333333", jq("@rows:eq(0) td").css("color"))
      verifyContains("rgb(227, 235, 246)#e3ebf6", jq("@rows:eq(0) td").css("backgroundColor"))
      verifyEquals("", jq("@rows:eq(1) td").eval("get(1).style.border"))
      var color = jq("@rows:eq(1) td").css("color")
      verifyContains("rgba(0, 0, 0, 0.9)#000000", color)
      println(jq("@rows:eq(1) td").css("color"))
      verifyContains("transparent|rgb(255, 255, 255)|rgba(0, 0, 0, 0)|#ffffff", jq(
        "@rows:eq(1) td").css("backgroundColor"))
    })
  }
}