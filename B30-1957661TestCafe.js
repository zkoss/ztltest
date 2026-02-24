import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1957661TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1957661TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
It is correct, if you saw "MyFunction" below.
<separator bar="true"/>
<zscript>
import org.zkoss.xel.Function;
import org.zkoss.xel.util.MethodFunction;
import org.zkoss.xel.util.SimpleMapper;

public class MyFunction extends SimpleMapper {
	public Function resolveFunction(String prefix, String name) {
		if ("getString".equals(name)) {
			try {
				return new MethodFunction(MyFunction.class.getMethod("getString", null));
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static String getString(){
		return "MyFunction";
	}
}
page.addFunctionMapper(new MyFunction());
</zscript>
<label value="\${c:getString()}"/>
</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@label:last").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("MyFunction"));
});
