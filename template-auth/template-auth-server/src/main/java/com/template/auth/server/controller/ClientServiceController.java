package com.template.auth.server.controller;

import com.template.auth.server.biz.ClientBiz;
import com.template.auth.server.entity.Client;
import com.template.common.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create By Project Pcc_Microservice
 *
 * @author zrb
 * @date 2018/4/15
 * description
 */
@RestController
@RequestMapping("service")
public class ClientServiceController extends BaseController<ClientBiz,Client> {



}
