/* B50_ZK_493Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Mar 28 18:10:31 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import scala.collection.JavaConversions._
import org.junit.Test;
import org.zkoss.ztl.Element;
import org.zkoss.ztl.JQuery;
import org.zkoss.ztl.Tags;
import org.zkoss.ztl.util.Scripts;
import org.zkoss.ztl.Widget;
import org.zkoss.ztl.ZK;
import org.zkoss.ztl.ZKClientTestCase;
import java.lang._

/**
 * A test class for bug ZK-493
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-493.zul,A,M,BI")
class B50_ZK_493Test extends ZTL4ScalaTestCase {
	
  @Test
  def testClick() = {
    val zscript = """
			<zk>
				<script>
					zk.afterLoad(function () {
						var aa = zk.$extends(zk.Object, {
							f: function () {
								return 'aa';
							},
							g: function () {
								return 'cc';
							}
						});
						var bb = zk.$extends(aa, {});
						zk.override(aa.prototype, 'f', function () {
							return this.$f.apply(this, arguments) + 'bb';
						});
						var _aa = {};
						zk.override(aa.prototype, _aa, {
							g: function () {
								return _aa.g.apply(this, arguments) + 'dd';
							}
						});
						var a = new aa(), b = new bb();
						zk.log(a.f(), a.g());
						zk.log(b.f(), b.g());
					});
				</script>
				<div>
					You shall see 'aabb', 'ccdd' exactly twice in zk log, with no javascript error.
				</div>
			</zk>

    """

    runZTL(zscript,
        () => {
        sleep(400); // wait for zk.log to show up
        var str: java.lang.String = jq("textarea").get(0).get("value");
        var index: Int = 0;

        verifyTrue("You should see 'aabb, ccdd'",
            str.indexOf("aabb, ccdd") >= 0);
        index = str.indexOf("aabb, ccdd") + 1;

        verifyTrue("And it is exactly twice",
            str.indexOf("aabb, ccdd", index) >= 0);
        index = str.indexOf("aabb, ccdd", index) + 1;

        verifyFalse("No more",
            str.indexOf("aabb, ccdd", index) >= 0);
        verifyFalse("Should no js error",
            jq(".z-error").exists());
    }
   );
  }
}