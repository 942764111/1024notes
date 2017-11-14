javax.servlet
#Interface ServletResponse

----------

- 所有已知种子接口:
- HttpServletResponse
- 所有已知实现类:
- HttpServletResponseWrapper,ServletResponseWrapper

----------
- public interface ServletResponse
- 定义一个对象帮助一个servlet发送响应给客户端。
- servlet容器创建一个ServletResponse对象并将它作为参数传递到servlet的服务方法。
- 发送二进制数据使用返回的ServletOutputStream getOutputStream()。
- 发送字符数据,使用PrintWriter对象返回的getWriter()。
- 混合二进制和文本数据,例如,创建一个多部分反应,使用ServletOutputStream和手动管理角色的部分。
- MIME的字符集的身体反应可以显式地指定使用setCharacterEncoding(以)和setContentType(以)方法,
- 或隐式地使用setLocale(java.util.Locale)方法。
- 明确规范优先于隐式的规范。如果没有指定字符集,将使用iso - 8859 - 1。setContentType,setCharacterEncoding getWriter之前必须调用setLocale方法和之前使用的字符编码的响应。
- 看到互联网RFC RFC 2045等关于MIME的更多信息。协议如SMTP和HTTP定义概要文件的MIME,和这些标准仍在发展。
- 作者:
- Various
- 参见:
- ServletOutputStream

----------
#方法总结(Method Detail)

----------
##1、java.lang.String getCharacterEncoding()
- 返回字符编码的名称(MIME字符集)用于身体发送响应。
- 指定的字符编码可能是显式地使用setCharacterEncoding(以)或setContentType(以)方法,
- 或隐式地使用setLocale(java.util.Locale)方法。
- 明确规范优先于隐式的规范。
- 调用了这些方法后getWriter被称为反应发生后或没有影响的字符编码。如果没有指定字符编码,将返回iso - 8859 - 1。
- 有关更多信息,请参见RFC 2047(http://www.ietf.org/rfc/rfc2047.txt)字符编码和哑剧。
- 返回:
- 一个字符串指定字符编码的名称,例如,utf - 8
##2、java.lang.String getContentType()
- 返回用于MIME内容类型的身体发送响应。
- 使用指定的内容类型正确的一定是setContentType(以)之前提交的响应。
- 如果没有指定的内容类型,这个方法返回null。
- 如果已指定一个内容类型和字符编码已显式或隐式地指定为描述getCharacterEncoding(),
- 返回的字符集参数包含在字符串。如果没有指定字符编码字符集参数被省略。
- 返回:
- 一个字符串指定内容类型,例如,"text / html;charset = utf - 8",或为"null"
- 自:
- 2.4
##3、ServletOutputStream getOutputStream()
                                    throws java.io.IOException
- 返回一个ServletOutputStream适合写二进制数据的响应。
- servlet容器不编码二进制数据。
- 调用flush()ServletOutputStream提交响应。这个方法或getWriter()可能会写,不是两个。
- 返回:
- 一个写作ServletOutputStream二进制数据
- 抛出:
- java.lang.IllegalStateException ——如果getWriter方法被称为反应
- java.io.IOException ——如果一个输入或输出异常发生
- 参见:
- getWriter()
##4、java.io.PrintWriter getWriter()
                              throws java.io.IOException
- 返回一个PrintWriter对象可以发送字符文本到客户端。
- 返回的字符编码使用的PrintWriter getCharacterEncoding()。
- 如果响应中描述的字符编码未指定为getCharacterEncoding(即。,该方法只是返回默认值iso - 8859 - 1),
- getWriter更新iso - 8859 - 1。
- 调用flush()PrintWriter提交响应。
- 这个方法或getOutputStream()可能会写,不是两个。
- 返回:
- 使用PrintWriter对象可以返回字符数据给客户端
- 抛出:
- java.io.UnsupportedEncodingException ——如果不能使用getCharacterEncoding返回的字符编码
- java.lang.IllegalStateException——如果getOutputStream方法已经呼吁这个响应对象
- java.io.IOException——如果一个输入或输出异常发生
- 参见:
- getOutputStream(), setCharacterEncoding(java.lang.String)
##5、void setCharacterEncoding(java.lang.String charset)
- 设置字符编码(MIME字符集)的响应被发送到客户端,例如,utf - 8。
- 如果设定的字符编码已经setContentType(java.lang.String)或setLocale(java.util.Locale),该方法覆盖它。
- 调用setContentType(java.lang.String)的字符串text / html和调用该方法用utf - 8编码的字符串是相同的
- 字符串调用setContentType "text / html;charset = utf - 8"。
- 这种方法可以调用多次改变字符编码。
- 这个方法没有效果,如果它被称为getWriter后被称为或之后发生的响应。
- 容器必须交流使用的字符编码servlet响应的作家到客户端如果协议提供了一种方法。
- 在HTTP的情况下,字符编码传达作为content - type报头的一部分用于文本媒体类型。
- 注意字符编码不能沟通通过HTTP头如果servlet不指定一个内容类型;
- 然而,它仍然是用于编码文本通过servlet响应的作家写的。
- 参数:
- charset——一个字符串指定唯一定义的字符集IANA字符集(http://www.iana.org/assignments/character-sets)
- 自:
- 2.4
- 参见:
- setLocale

----------
##<div class = "bg-blue">例:<div>
- [点击查看](demo/setContentType/setContentType.html)
##6、void setContentLength(int len)
- 设置内容长度头。
- 参数:
- len——一个整数指定长度的内容返回给客户端,设置内容长度头
##7、void setContentType(java.lang.String type)
- 设置内容类型的响应发送到客户端,如果尚未提交的响应。
- 给定的内容类型可能包括一个字符编码规范,
- 例如,text / html;charset = utf - 8。
- 如果getWriter响应的字符编码只是从给定的内容类型设置叫做前调用此方法。
- 这种方法可能会反复调用改变内容类型和字符编码。调用这个方法没有效果,
- 如果响应后提交。它没有设置响应的字符编码后如果它被称为getWriter被称为或之后发生的响应。
- 容器必须沟通内容类型和字符编码用于servlet响应的作家到客户端如果协议提供了一种方法。
- 在HTTP中,使用content - type报头。
- 参数:
- 类型——一个字符串指定内容的MIME类型 例("text / html")
- 参见:
- setLocale(java.util.Locale), setCharacterEncoding(java.lang.String), getOutputStream(), getWriter()
##8、void setBufferSize(int size)
- 设置首选缓冲区大小的身体反应。servlet容器将使用一个缓冲至少一样大的尺寸要求。
- 实际使用的缓冲区大小可以使用getBufferSize找到。
- 更大的缓冲允许写过任何更多的内容实际上是发送,
- 因此为servlet提供更多的时间来设置适当的状态代码和标题。
- 一个较小的缓冲减少服务器内存负载,允许客户端更快地开始接收数据。
- 之前必须调用此方法编写响应正文内容,如果内容已经书面或响应对象,该方法抛出IllegalStateException。
- 参数:
- size——首选的缓冲区大小
- 抛出:
- java.lang.IllegalStateException——如果写内容后调用此方法
- 参见:
- setBufferSize(int), flushBuffer(), isCommitted(), reset()
##10、int getBufferSize()
- 用于响应返回实际的缓冲区大小。如果使用无缓冲,这个方法将返回0。
- 返回:
- 实际使用的缓冲区大小
- 参见:
- setBufferSize(int), flushBuffer(), isCommitted(), reset()
##11、void flushBuffer()
                 throws java.io.IOException
- 部队在缓冲区被写入任何内容到客户机。调用该方法自动提交的响应,即状态代码和标题会写。
##12、void resetBuffer()
- 清除潜在的缓冲区的内容在响应中没有清除头或状态代码。
- 如果响应已经承诺,该方法抛出IllegalStateException。
- 自:
- 2.3
- 参见:
- setBufferSize(int), flushBuffer(), isCommitted(), reset()
##13、boolean isCommitted()
- 返回一个布尔值表示如果响应已经提交。
- 承诺的响应代码编写和标题已经有了自己的地位。
- 返回:
- 一个布尔值表示如果响应已经提交
- 参见:
- setBufferSize(int), flushBuffer(), isCommitted(), reset()
##14、void reset()
- 清除缓冲区中的任何数据存在的状态码和标题。如果响应已经承诺,该方法抛出IllegalStateException。
- Throws:
- java.lang.IllegalStateException - 如果已经提交的响应
- See Also:
- setBufferSize(int), getBufferSize(), flushBuffer(), isCommitted()
##15、void setLocale(java.util.Locale loc)
- 设置语言环境的反应,如果反应尚未提交。
- 它还设置响应的字符编码适当语言环境,
- 如果没有显式地设置字符编码使用setContentType(以)或setCharacterEncoding(以),getWriter尚未被称为,和尚未提交的响应。
- 如果部署描述符包含一个locale-encoding-mapping-list元素,该元素提供了一个给定区域映射,映射是使用。
- 否则,从地区到字符编码的映射是依赖于容器的。
- 这种方法可能会反复调用改变语言环境和字符编码。
- 反应后的方法没有效果,如果已经提交。它没有设置响应的字符编码后如果它被称为setContentType与字符集(以)被称为规
- 范,setCharacterEncoding后(以)被称为getWriter被称为后,或之后发生的响应。
- 容器必须交流场所和字符编码用于servlet响应的作家到客户端如果协议提供了一种方法。
- 在HTTP的情况下,通过内容语言头地区沟通,content - type报头的字符编码作为文本媒体类型。
- 注意字符编码不能沟通通过HTTP头如果servlet不指定一个内容类型;然而,它仍然是用于编码文本通过servlet响应的作家写的。
- 参数:
- loc——响应的语言环境
- 参见:
- getLocale(), setContentType(java.lang.String), setCharacterEncoding(java.lang.String)
##16、java.util.Locale getLocale()
- 返回此响应使用指定的语言环境setLocale(java.util.Locale)方法。
- 调用setLocale后反应是没有影响。如果没有指定区域,返回容器的默认语言环境。
- 参见:
- setLocale(java.util.Locale)