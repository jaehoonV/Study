$.validator.addMethod("regex", function (value, element, regexp) {
    let re = new RegExp(regexp);
    let res = re.test(value);
    return res;
});


var frm = document.frm;
$("#frm").validate({
    rules: {
        userName: {
            required: true,
            rangelength: [2, 10]
        },
        userEmail: {
            required: true,
            email: true
        },
        userPhone: {
            required: true,
            regex: "^(010|011)[-\\s]?\\d{3,4}[-\\s]?\\d{4}$"
        },
        userPassword: {
            required: true,
            regex: "^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+])(?!.*[^a-zA-z0-9$`~!@$!%*#^?&\\(\\)\-_=+]).{8,15}$",
        },
        userGender: {
            required: true,
        }
    },
    messages: {
        userName: {
            required: "이름은 필수 입력입니다.",
            rangelength: "이름은 {0}자에서 {1}자까지 사용 가능합니다."
        },
        userEmail: {
            required: "이메일은 필수 입력입니다.",
            email: "이메일 형식을 확인하세요."
        },
        userPhone: {
            required: "전화번호는 필수 입력입니다.",
            regex: "전화번호 양식을 확인해주세요."
        },
        userPassword: {
            required: "비밀번호는 필수 입력입니다.",
            regex: "비밀번호 양식은 영문, 숫자, 특수문자 포함 (8~15)입니다.",
        },
        userGender: {
            required: "성별은 필수 사항입니다."
        }
    },
    errorPlacement: function (err, element) {
        if (element.is(":radio") || element.is(":checkbox")) {
            element.parent().after(err);
        } else {
            element.after(err);
        }
    },
    submitHandler: function () {
        frm.submit();
    }
});