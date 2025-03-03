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
	        implementation 'com.github.vtabk2:BaseAndroid:1.1.1'
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