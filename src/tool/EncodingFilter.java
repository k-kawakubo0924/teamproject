package tool;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")  // すべてのリクエストに適用
public class EncodingFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // リクエストの文字エンコーディングをUTF-8に統一
        request.setCharacterEncoding("UTF-8");

        // 次のフィルターまたはサーブレットに処理を渡す
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {
        // 初期化処理が必要ならここに記述
    }

    public void destroy() {
        // 終了処理が必要ならここに記述
    }
}
