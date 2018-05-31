package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2481.zul")
class B70_ZK_2481Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """

<window width="100%" height="100%" title="Testing with ZK ${desktop.webApp.version}" border="normal">
    <navbar orient="horizontal" collapsed="false">
        <nav label="Application Menu">
            <navitem label="Dashbaord"/>
                <nav label="Admin" badgeText=">>">
                    <navitem label="Analysis Hierarchies Administration"/>
                    <navitem label="Fab Layout Administration"/>
                    <navitem label="PULSE Adminstration Client"/>
                    <nav label="PULSE Documentation" badgeText=">>">
                        <navitem label="PULSE Administrators Guide"/>
                        <navitem label="PULSE Integerators Guide"/>
                        <navitem label="PULSE Release Notes"/>
                        <navitem label="PULSE Users Guide"/>
                    </nav>
                </nav>
            <navitem label="Sitemap"/>
            <navitem label="Help"/>
            <navitem label="About..."/>
        </nav>
    </navbar>
    <separator height="100px"/>
    <div style="float:right">
        <label value="The same navbar with float:right"/>
        <separator/>
        <navbar orient="horizontal" collapsed="false">
            <nav label="Application Menu" >
                <navitem label="Dashbaord"/>
                <nav label="Admin" badgeText=">>">
                    <navitem label="Analysis Hierarchies Administration"/>
                    <navitem label="Fab Layout Administration"/>
                    <navitem label="PULSE Adminstration Client"/>
                    <nav label="PULSE Documentation" badgeText=">>">
                        <navitem label="PULSE Administrators Guide"/>
                        <navitem label="PULSE Integerators Guide"/>
                        <navitem label="PULSE Release Notes"/>
                        <navitem label="PULSE Users Guide"/>
                    </nav>
                </nav>
                <navitem label="Sitemap"/>
                <navitem label="Help"/>
                <navitem label="About..."/>
            </nav>
        </navbar>
    </div>
</window>
"""
    runZTL(zscript,
      () => {
        var navbar = jq(".z-navbar:last a");
        click(navbar);
        waitResponse();
        var navitem = jq(".z-navbar:last>ul>li>ul");
        verifyTrue(navitem.positionLeft() != 0);

      })

  }
}