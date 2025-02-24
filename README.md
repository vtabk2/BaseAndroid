# BaseAndroid

**Gradle**
**Step 1.** Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
```css
dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
```
**Step 2.** Add the dependency
```css
dependencies {
	        implementation 'com.github.vtabk2:BaseAndroid:1.0.15'
	}
```

**Hướng dẫn**

- LiveDataUntil : tác dụng là không load hết data mà sẽ chỉ load trước 1 phần để hiển thị nhanh hơn

```css
  viewModel.listLiveData.observeUntil(owner = viewLifecycleOwner,
  predicate = {
  it.size > 0
  },
  observer = { list ->
  if (list.isEmpty()) return@observeUntil
  // load data list nhanh hơn  bằng cách load trước 1 ít
  )
```
- LiveDataNetworkStatus : tác dụng kiểm tra sự thay đổi trạng thái kết nối mạng (tắt, bật mạng)

- launchWhenResumed : check activity có còn khi resume không
```css
launchWhenResumed {
    // todo
}
```
- admob : cấu hình trong config_admob
- BannerUtils
- InterstitialUtils
- NativeUtils
- RewardedInterstitialUtils

- AppOpenAdManager
- AppResumeAdManager

- Tùy biến NativeAdView thì chọn ads_mode = custom

```css
        <com.core.gsadmob.natives.view.NativeGsAdView
            android:id="@+id/nativeCustom"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="10dp"
            app:ads_mode="custom"/>
```

- Cách 1: Giữ id gốc chỉ đổi id layout
```css
        val builder = BaseNativeAdView.Builder().apply {
            adLayoutId = R.layout.ad_native_test
        }
        bindingView.nativeCustom.applyBuilder(builder)
```

- Cách 2: Đổi tất cả id thì cấu hình lại trong builder: id = 0 khi không có trong layout
```css
        val builder = BaseNativeAdView.Builder().apply {
            adLayoutId = R.layout.ad_native_test
            adHeadlineId = R.id.ad_headline_test
            adBodyId = 0
            adStarsId = R.id.ad_stars_test
            adAppIconId = R.id.ad_app_icon_test
            adCallToActionId = R.id.ad_call_to_action_test
            adViewId = R.id.ad_view_test
            adMediaViewId = 0
            adShimmerId = R.id.ad_view_test_shimmer
        }
        bindingView.nativeCustom.applyBuilder(builder)
```

- Cách 3:

```css
        <com.core.gsadmob.natives.view.NativeGsAdView
            android:id="@+id/nativeCustom"
            style="@style/NativeTest"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="10dp"
            app:ads_mode="custom"/>

        <style name="NativeTest" parent="BaseNativeCustom">
            <item name="adLayoutId">@layout/ad_native_test</item>
            <item name="adHeadlineId">@id/ad_headline_test</item>
            <!--        <item name="adBodyId">@id/ad_body_test</item>-->
            <item name="adStarsId">@id/ad_stars_test</item>
            <item name="adAppIconId">@id/ad_app_icon_test</item>
            <item name="adCallToActionId">@id/ad_call_to_action_test</item>
            <item name="adViewId">@id/ad_view_test</item>
            <!--        <item name="adMediaViewId">@id/ad_media_test</item>-->
            <item name="adShimmerId">@id/ad_view_test_shimmer</item>
        </style>
```
- Cách load native

```css
        NativeUtils.loadNativeAds(this, this, isVip = false, callbackStart = {
            bindingView.nativeCustom.startShimmer()
        }, callback = { nativeAd ->
            bindingView.nativeCustom.setNativeAd(nativeAd)
        })
```