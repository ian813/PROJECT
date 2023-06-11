  // // ajax 를 위한 xmlhttprequest 객체 생성
  // const xhr = new XMLHttpRequest();
  // // GET 방식
  // const method = "GET";
  // // json 파일 위치
  // const url = "./data/video.json";

  // // 요청 초기화
  // xhr.open(method, url);
  // // 헤더 정보 초기화
  // xhr.setRequestHeader("Content-Type", "application/text");

  // // 객체 상태 변화 이벤트 핸들러 함수 정의
  // xhr.onreadystatechange = function () {
  //   if (xhr.readyState === xhr.DONE) {
  //     if (xhr.status === 200) {
  //       const resJson = JSON.parse(xhr.responseText);
  //       const videoData = resJson.videos;

  //       let videoList = document.querySelector(".content-video-list");
  //       for (let i = 0; i < videoData.length; i++) {
  //         let videoItem = `
  //           <div class="card p-3 mb-3 col-12 col-md-6 col-lg-3">
  //             <iframe allowfullscreen src="${videoData[i]["url"]}" frameborder="2"></iframe>
  //             <div class="video-info d-flex justify-content-around mt-2">
  //               <div class="card-text" style="font-size: 0.9rem;">
  //                 <div>${videoData[i]["title"]}</div>
  //                 <hr>
  //                 <div>${videoData[i]["part"]}</div>
  //                 <div>${videoData[i]["channelName"]}</div>
  //               </div>
  //             </div>
  //           </div>
  //           `;
  //         videoList.innerHTML += videoItem;
  //       }
  //     }
  //   }
  // };

// xhr.send();

function regist() {
  let id = document.getElementById("id").value;
  let password = document.getElementById("password").value;
  let name = document.getElementById("name").value;
  let email = document.getElementById("email").value;
  let age = document.getElementById("age").value;

  if (!id || !password || !name || !email || !age) {
    alert("빈칸이 없도록 입력해주세요.");
    return;
  } else {
    const user = {
      id: id,
      password: password,
      name: name,
      email: email,
      age: age,
    };

    localStorage.setItem("user", JSON.stringify(user));
    alert("사용자 등록 성공!");
    window.location.replace("login.html");
  }
}

function login() {
  let id = document.getElementById("id").value;
  let password = document.getElementById("password").value;

  const user = JSON.parse(localStorage.getItem("user"));

  if (
    user.id &&
    user.password &&
    user.id === id &&
    user.password === password
  ) {
    alert("로그인 성공 !");
    window.location.replace("main.html");
  } else {
    alert("로그인 실패 !");
  }
}
