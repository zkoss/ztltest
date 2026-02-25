import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1823278TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-1823278.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-1823278TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-listitem:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.pressKey("down")
		.wait(30)
		.pressKey("down")
		.wait(30)
		.pressKey("down")
		.wait(30)
		.pressKey("down")
		.wait(30)
		.pressKey("down")
		.wait(30)
		.pressKey("down")
		.wait(30)
		.pressKey("down")
		.wait(30)
		.pressKey("down")
		.wait(30)
		.pressKey("down")
		.wait(30)
		.pressKey("down")
		.wait(30)
		.pressKey("down")
		.wait(30)
		.pressKey("down")
		.wait(30)
		.pressKey("down")
		.wait(30)
		.pressKey("down")
		.wait(30)
		.pressKey("down")
		.wait(30);
	let scrollTop_cafe = parseInt(
		await ClientFunction(
			() => zk.Desktop._dt.$f("listbox", true).$n("body").scrollTop,
		)(),
	);
	await t
		.expect(150 < scrollTop_cafe)
		.ok("Times of pressing Down: 15, scrollTop_cafe: " + scrollTop_cafe);
	await t
		.pressKey("up")
		.wait(30)
		.pressKey("up")
		.wait(30)
		.pressKey("up")
		.wait(30)
		.pressKey("up")
		.wait(30)
		.pressKey("up")
		.wait(30)
		.pressKey("up")
		.wait(30)
		.pressKey("up")
		.wait(30)
		.pressKey("up")
		.wait(30)
		.pressKey("up")
		.wait(30)
		.pressKey("up")
		.wait(30)
		.pressKey("up")
		.wait(30)
		.pressKey("up")
		.wait(30)
		.pressKey("up")
		.wait(30)
		.pressKey("up")
		.wait(30)
		.pressKey("up")
		.wait(30);
	scrollTop_cafe = parseInt(
		await ClientFunction(
			() => zk.Desktop._dt.$f("listbox", true).$n("body").scrollTop,
		)(),
	);
	await t
		.expect(3 > scrollTop_cafe)
		.ok("Times of pressing Down: 15, scrollTop_cafe: " + scrollTop_cafe);
});
