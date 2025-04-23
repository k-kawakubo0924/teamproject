package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;

public class LogoutAction implements Action {
    public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        // セッションを取得
        HttpSession session = req.getSession(false); // 既存のセッションがある場合のみ取得

        if (session != null) {
            // セッションの無効化（完全に破棄）
            session.invalidate();
        }

        // ログイン画面に遷移
        return "/login.jsp";
    }
}
