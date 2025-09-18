function requestWithToken(url, method, async, data = null, success_c = null, error_c = null, complete_c = null) {
    const $ = layui.jquery;
    let options = {
        url,
        type: method,
        headers: {
            Authorization: localStorage.getItem("token")
        },
        contentType: 'application/json;charset=utf8',
        success: (response) => {
            if (success_c) {
                success_c(response);
            }
        },
        error: (res) => {
            if (res.status === 401) {
                localStorage.removeItem("token");
                location.href = "login.html";
                return;
            }
            if (error_c) {
                error_c(res);
            }
        },
        complete: (res) => {
            if (complete_c) {
                complete_c(res);
            }
        },
        async
    };
    if (data) {
        options.data = JSON.stringify(data);
    }
    $.ajax(options);
}
